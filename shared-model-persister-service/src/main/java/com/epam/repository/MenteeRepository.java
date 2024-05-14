package com.epam.repository;

import com.epam.model.ActiveMenteeDetails;
import com.epam.model.Employee;
import com.epam.model.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenteeRepository extends JpaRepository<Mentee, Integer> {

    @Query("select new com.epam.model.ActiveMenteeDetails(e.empId,e.name,e.email," +
            "m.addedDate as start_date,m.targetMonthForUA) " +
            "from Employee e join Mentee m on m.empId = e.empId " +
            "where status in ('ACTIVE','IN_PROGRESS')")
    public List<ActiveMenteeDetails> findAllActiveAndInProgressMentees();
}
