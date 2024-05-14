package com.epam.ua.notify;

import com.epam.ua.model.MentorNotification;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.web.client.RestTemplate;

public class NotificationTest {
    private static final String NTFY_NEW_MENTOR = "https://prod-15.westeurope.logic.azure.com:443/workflows/7941c8de54014dfc88c3fb2ff1a5e38f/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=9PaMmeSozYpVcyR8cbyDyv9fUaXtSs9GBgqISnd2heg";

    public static void main(String[] args) throws UnirestException, JsonProcessingException {
        new NotificationTest().sendNotificationToMentor2();
    }

    public void sendNotificationToMentor2() throws UnirestException, JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(getMentorData());
        System.out.println("Json :" + json);
        HttpResponse<String> response = Unirest.post("https://prod-15.westeurope.logic.azure.com:443/workflows/7941c8de54014dfc88c3fb2ff1a5e38f/triggers/manual/paths/invoke?api-version=2016-06-01&sp=%2Ftriggers%2Fmanual%2Frun&sv=1.0&sig=9PaMmeSozYpVcyR8cbyDyv9fUaXtSs9GBgqISnd2heg")
                .header("content-type", "application/json")
                .header("cache-control", "no-cache")
                .header("postman-token", "4e1ce6bf-83eb-4ddb-0cff-6c3ba68e8322")
                .body("{\r\n  \"assoc_id\" : 1,\r\n  \"Mentor_Name\": \"Shiva Kurremula\",\r\n  \"Mentor_Mail\": \"Shivakrishna_kurremula@epam.com\",\r\n  \"Mentee_Name\": \"Shivakrishna Kurremula\",\r\n  \"Mentee_Mail\": \"Shivakrishna_kurremula@epam.com\",\r\n  \"Created_By\": \"Shiva_kurremula@epam.com\",\r\n  \"Mentee_Link\": \"https://www.google.com/\",\r\n  \"Submitted_On\": \"29-12-2021\"\r\n}\r\n")
                .asString();
        System.out.println("Mail Sent");
    }

    private void sendNotificationToMentor() {

        RestTemplate restTemplate = new RestTemplate();
        MentorNotification notf = getMentorData();
        MentorNotification addedNotification = restTemplate.postForObject(NTFY_NEW_MENTOR, notf, MentorNotification.class);
        System.out.println("Notification added : " + addedNotification.getAssocId());
    }

    private MentorNotification getMentorData() {
        return new MentorNotification().setAssocId("123")
                .setMentorMail("Shivakrishna_kurremula@epam.com")
                .setMentorName("Shivakrishna_kurremula@epam.com")
                .setMenteeMail("Shivakrishna_kurremula@epam.com")
                .setMenteeName("Shivakrishna_kurremula@epam.com")
                .setCreatedBy("Shivakrishna_kurremula@epam.com")
                .setSubmittedOn("29-12-2021");

    }
}
