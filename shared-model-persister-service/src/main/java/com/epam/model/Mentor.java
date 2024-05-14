package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Mentor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "emp_id")
    private int empId;

    @Column(name = "menteesLimit")
    private int menteesLimit;

    @Column(name = "skills")
    private String skills;

    @Column(name = "available_slot_1")
    private String availableSlot1;

    @Column(name = "available_slot_2")
    private String availableSlot2;

    @Column(name = "available_slot_3")
    private String availableSlot3;

    private enum StatusEnum {
        NEW,
        APPROVED,
        REJECTED,
        INACTIVE;
    };

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
