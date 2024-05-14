package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "Committee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Committee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "committee_head_id")
    private int committeeHeadId;

    @Column(name = "committee_member_1")
    private int committeeMember1;

    @Column(name = "committee_member_2")
    private int committeeMember2;

    @Column(name = "committee_member_3")
    private int committeeMember3;

    private enum StatusEnum {
        NEW,
        NOTIFIED,
        ACTIVE,
        INACTIVE;
    };

    @Column(name = "status",columnDefinition = "enum('NEW','NOTIFIED','ACTIVE','INACTIVE')")
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
}
