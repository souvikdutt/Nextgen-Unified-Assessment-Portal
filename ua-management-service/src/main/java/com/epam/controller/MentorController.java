package com.epam.controller;

import com.epam.model.MentorAvailabilityDetails;
import com.epam.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mentor")
@CrossOrigin(origins = "http://localhost:3000")
public class MentorController {

    @Autowired
    private MentorService mentorService;

    @GetMapping("/available")
    public List<MentorAvailabilityDetails> getAvailableMentors(){
        return mentorService.getAvailableMentors();
    }
}
