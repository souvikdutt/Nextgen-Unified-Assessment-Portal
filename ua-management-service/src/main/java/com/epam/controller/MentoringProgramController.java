package com.epam.controller;

import com.epam.model.MentoringProgram;
import com.epam.service.MentoringProgramService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "http://localhost:3000")
public class MentoringProgramController {

    @Autowired
    private MentoringProgramService mentoringProgramService;

    @PostMapping("/mentor")
    public MentoringProgram raiseRequest(@RequestBody MentoringProgram mentoringProgram) throws UnirestException, JsonProcessingException {
        return mentoringProgramService.raiseRequest(mentoringProgram);
    }

    @GetMapping("/status")
    public String raiseRequest(@RequestParam Map<String, String> allParams) throws UnirestException, JsonProcessingException {
        return mentoringProgramService.updateStatus(allParams);
    }
}
