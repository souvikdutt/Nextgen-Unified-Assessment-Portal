package com.epam.service;

import com.epam.model.Committee;
import com.epam.repository.CommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeService {

    @Autowired
    private CommitteeRepository committeeRepository;

    public List<Committee> getAllCommittees() {
        return committeeRepository.findAll();
    }

    public Committee createCommittee(Committee committee){
        return committeeRepository.save(committee);
    }

    public Committee addMember(Committee committee){
        return committeeRepository.save(committee);
    }
}
