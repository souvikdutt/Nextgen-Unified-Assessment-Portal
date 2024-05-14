package com.epam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MentorAvailabilityDetails {

    private int empId;
    private String name;
    private String email;
    private String isAvailable;
    private long availableMenteesSlot;
}
