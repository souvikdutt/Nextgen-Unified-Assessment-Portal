package com.epam.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NotificationDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDetails {

    public NotificationDetails(int menteeID, String menteeName, String menteeEmail, int mentorId, String mentorName, String mentorEmail, String createdBy) {
        this.menteeID = menteeID;
        this.menteeName = menteeName;
        this.menteeEmail = menteeEmail;
        this.mentorId = mentorId;
        this.mentorName = mentorName;
        this.mentorEmail = mentorEmail;
        this.createdBy = createdBy;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "mentee_id")
    private int menteeID;

    @Column(name = "mentee_name")
    @JsonProperty("Mentee_Name")
    private String menteeName;

    @Column(name = "mentee_email")
    @JsonProperty("Mentee_Mail")
    private String menteeEmail;

    @Column(name = "mentor_id")
    private int mentorId;

    @Column(name = "mentor_name")
    @JsonProperty("Mentor_Name")
    private String mentorName;

    @Column(name = "mentor_email")
    @JsonProperty("Mentor_Mail")
    private String mentorEmail;

    @Column(name = "created_by")
    @JsonProperty("Created_By")
    private String createdBy;

    @Column(name = "mentee_link")
    @JsonProperty("Mentee_Link")
    private String menteeLink;

    @Column(name = "submitted_on")
    @JsonProperty("Submitted_On")
    private String submittedOn;

    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @Column(name = "mentoring_program_id")
    private int mentoringProgramId;
}
