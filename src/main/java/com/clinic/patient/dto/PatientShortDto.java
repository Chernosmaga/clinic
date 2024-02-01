package com.clinic.patient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientShortDto {
    private Long id;
    private String name;
    private String surname;
    private String secondName;
    private String inn;
}
