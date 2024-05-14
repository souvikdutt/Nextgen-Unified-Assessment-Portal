package com.epam.repository;

import com.epam.model.Mentor;
import com.epam.model.MentorAvailabilityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer>{

    @Query("select new com.epam.model.MentorAvailabilityDetails(e.empId,e.name,e.email,\n" +
            "CASE WHEN m.menteesLimit-count(mp.mentorEmpId) >=1 THEN 'Y' ELSE 'N' END as isAvailable, m.menteesLimit-count(mp.mentorEmpId) as availableMenteesSlot)\n" +
            "from Employee e \n" +
            "join Mentor m on m.empId = e.empId \n" +
            "join MentoringProgram mp on mp.mentorEmpId = m.empId and mp.status = 'ACCEPTED'\n" +
            "where m.status = 'ACTIVE'  \n" +
            "group by mp.mentorEmpId")
    List<MentorAvailabilityDetails> findMentorsWithAvailabilityStatus();


}