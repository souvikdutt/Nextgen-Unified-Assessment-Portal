package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveMenteeDetails {

    private int empId;
    private String name;
    private String email;
    private Date addedDate;
    private String targetMonth;
}
