package com.epam.service;

import com.epam.model.MentoringProgram;
import com.epam.model.NotificationDetails;
import com.epam.repository.MentoringProgramRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Map;

@Service
@Transactional
public class MentoringProgramService {

    @Autowired
    private MentoringProgramRepository mentoringProgramRepository;

    private static String ENDPOINT_URL = "https://prod-15.westeurope.logic.azure.com:443/workflows/7941c8de54014dfc88c3fb2ff1a5e38f/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=9PaMmeSozYpVcyR8cbyDyv9fUaXtSs9GBgqISnd2heg";

    @Autowired
    @Lazy
    private RestTemplate template;

    public MentoringProgram raiseRequest(MentoringProgram mentoringProgram) throws UnirestException, JsonProcessingException {
        MentoringProgram resp = mentoringProgramRepository.save(mentoringProgram);
        NotificationDetails notificationDetails =
                mentoringProgramRepository.getMenteeMentorDetails(resp.getMenteeEmpId(), resp.getMentorEmpId());
        notificationDetails.setMentoringProgramId(resp.getId());
        notificationDetails.setSubmittedOn(new Date().toString());
        notificationDetails.setMenteeLink("https://telescope.epam.com/who/Venkateswara_Garikipati?tab=profile");

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(notificationDetails);

        HttpResponse<String> response = Unirest.post("https://prod-15.westeurope.logic.azure.com:443/workflows/7941c8de54014dfc88c3fb2ff1a5e38f/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=9PaMmeSozYpVcyR8cbyDyv9fUaXtSs9GBgqISnd2heg")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .header("postman-token", "4e1ce6bf-83eb-4ddb-0cff-6c3ba68e8322")
                .body(json)
                .asString();
        return resp;
    }

    public String updateStatus(Map<String, String> params) throws UnirestException, JsonProcessingException {
        String status = "";
        int update = 0;
        if (params.get("status").equalsIgnoreCase("approve")) {
            status = "APPROVED";
            update = mentoringProgramRepository.updateStatus(Integer.parseInt(params.get("id")),status);
        }
        else if (params.get("status").equalsIgnoreCase("reject")) {
            status = "REJECTED";
            update = mentoringProgramRepository.updateStatus(Integer.parseInt(params.get("id")),status);
        }
        else
            status = "" ;

        if (update > 0) {

            NotificationDetails notificationDetails = new NotificationDetails();
            notificationDetails.setMentorName(params.get("mentor_name"));
            notificationDetails.setMenteeEmail(params.get("mentee_mail"));
            notificationDetails.setStatus(params.get("status"));

            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
            String json = ow.writeValueAsString(notificationDetails);

            HttpResponse<String> response = Unirest.post("https://prod-163.westeurope.logic.azure.com:443/workflows/0a1ee28ebb1747b78664688c09049209/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=Ulv1oSKWSFXziT4qONaKyLhFMqTyUU3g3i8J4JT80UI")
                    .header("content-type", "application/json")
                    .header("cache-control", "no-cache")
                    .header("postman-token", "162b6ff0-f247-5f9a-d8e1-a034d192bd00")
                    .body(json)
                    .asString();

            return "Updated";
        }
        return "Cant be updated";
    }
}
