package com.epam.controller;

import com.epam.model.ActiveMenteeDetails;
import com.epam.model.Employee;
import com.epam.model.Mentee;
import com.epam.model.MentorAvailabilityDetails;
import com.epam.service.MenteeService;
import com.epam.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/mentees")
@CrossOrigin(origins = "http://localhost:3000")
public class MenteeController {

    @Autowired
    private MenteeService menteeService;

    @GetMapping("/active")
    public List<ActiveMenteeDetails> getActiveMentees(){
        return menteeService.getActiveMentees();
    }

    @PostMapping("/register")
    public Mentee registerMentee(@RequestBody Mentee mentee){
        return menteeService.registerMentee(mentee);
    }
}
