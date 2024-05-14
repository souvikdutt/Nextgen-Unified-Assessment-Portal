package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;;
import java.util.Date;

@Entity
@Table(name = "Mentee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "emp_id")
    @NonNull
    private int empId;

    @Column(name = "target_month")
    @NonNull
    private String targetMonthForUA;

    @Column(name = "target_month_mock_interview")
    private String targetMonthForMockInterview;

    @Column(name = "mock_interview_slots")
    private String availableMockInterviewSlot;

    private enum StatusEnum {
        NEW,
        IN_PROGRESS,
        COMPLETED,
        INACTIVE;
        };

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @Column(name = "added_date")
    private Date addedDate;

    @Column(name = "target_position")
    @NonNull
    private String targetPosition;
}
