package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "Mentoring_Program")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentoringProgram {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "mentor_emp_id")
    private int mentorEmpId;

    @NonNull
    @Column(name = "mentee_emp_id")
    private int menteeEmpId;

    public enum StatusEnum {
        REQUESTED,
        ACCEPTED,
        REJECTED,
        COMPLETED,
        INACTIVE;
    };

    @Column(name = "status")
    //@Enumerated(EnumType.STRING)
    private String status;
}
