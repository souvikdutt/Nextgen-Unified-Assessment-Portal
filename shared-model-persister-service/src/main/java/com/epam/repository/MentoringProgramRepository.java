package com.epam.repository;

import com.epam.model.MentoringProgram;
import com.epam.model.NotificationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoringProgramRepository extends JpaRepository<MentoringProgram,Integer> {

    @Query("select new com.epam.model.NotificationDetails(me.empId,me.name,me.email,mr.empId," +
            "mr.name,mr.email,me.email) " +
            "from Employee me join Employee mr on me.empId != mr.empId " +
            "where me.empId=?1 and mr.empId=?2")
    public NotificationDetails getMenteeMentorDetails(int menteeId, int mentorId);

    @Modifying
    @Query("update MentoringProgram set status=?2 where id = ?1")
    public int updateStatus(int id, String status);

}
