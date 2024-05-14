package com.epam.service;

import com.epam.model.Mentor;
import com.epam.model.MentorAvailabilityDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.epam.repository.MentorRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MentorService {

    @Autowired
    private MentorRepository mentorRepository;

    public List<MentorAvailabilityDetails> getAvailableMentors(){
        return mentorRepository.findMentorsWithAvailabilityStatus()
                .stream()
                .filter(m->m.getIsAvailable().equals("Y"))
                .collect(Collectors.toList());
    }

    public Mentor registerMentor(Mentor mentor){
        return mentorRepository.save(mentor);
    }
}
