package com.epam.ua.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MentorNotification {

    private String assocId;
    private String mentorName;
    private String mentorMail;
    private String menteeName;
    private String menteeMail;
    private String menteeLink;
    private String createdBy;
    private String submittedOn;

    public String getAssocId() {
        return assocId;
    }

    public MentorNotification setAssocId(String assocId) {
        this.assocId = assocId;
        return this;
    }

    public String getMentorName() {
        return mentorName;
    }

    public MentorNotification setMentorName(String mentorName) {
        this.mentorName = mentorName;
        return this;
    }

    public String getMentorMail() {
        return mentorMail;
    }

    public MentorNotification setMentorMail(String mentorMail) {
        this.mentorMail = mentorMail;
        return this;
    }

    public String getMenteeName() {
        return menteeName;
    }

    public MentorNotification setMenteeName(String menteeName) {
        this.menteeName = menteeName;
        return this;
    }

    public String getMenteeMail() {
        return menteeMail;
    }

    public MentorNotification setMenteeMail(String menteeMail) {
        this.menteeMail = menteeMail;
        return this;
    }

    public String getMenteeLink() {
        return menteeLink;
    }

    public MentorNotification setMenteeLink(String menteeLink) {
        this.menteeLink = menteeLink;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public MentorNotification setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getSubmittedOn() {
        return submittedOn;
    }

    public MentorNotification setSubmittedOn(String submittedOn) {
        this.submittedOn = submittedOn;
        return this;
    }
}