package com.epam.service;

import com.epam.model.ActiveMenteeDetails;
import com.epam.model.Employee;
import com.epam.model.Mentee;
import com.epam.model.MentorAvailabilityDetails;
import com.epam.repository.MenteeRepository;
import com.epam.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenteeService {

    @Autowired
    private MenteeRepository menteeRepository;

    public List<ActiveMenteeDetails> getActiveMentees(){
        return menteeRepository.findAllActiveAndInProgressMentees();
    }

    public Mentee registerMentee(Mentee mentee){
        mentee.setAddedDate(new Date());
        return menteeRepository.save(mentee);
    }
}
