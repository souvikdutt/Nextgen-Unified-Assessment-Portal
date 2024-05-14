package com.epam.controller;

import com.epam.model.Committee;
import com.epam.service.CommitteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/committee")
public class CommitteeController {

    @Autowired
    private CommitteeService committeeService;

    @GetMapping("/all")
    public List<Committee> getAllCommittees(){
        return committeeService.getAllCommittees();
    }

    @PostMapping("/create")
    public Committee createCommittee(@RequestBody Committee committee){
        return committeeService.createCommittee(committee);
    }

    @PutMapping("/addMember")
    public Committee addMember(@RequestBody Committee committee){
        return committeeService.addMember(committee);
    }
}
