package com.clinic.patient.mapper;

import com.clinic.patient.dto.PatientDto;
import com.clinic.patient.dto.PatientShortDto;
import com.clinic.patient.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientMapper {

    public Patient toPatient(PatientDto patient) {
        return new Patient(
                patient.getName(),
                patient.getSurname(),
                patient.getSecondName(),
                patient.getBirthday(),
                patient.getInn());
    }

    public PatientDto toPatientDto(Patient patient) {
        return new PatientDto(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getSecondName(),
                patient.getBirthday(),
                patient.getInn());
    }

    public PatientShortDto toPatientShortDto(Patient patient) {
        return new PatientShortDto(
                patient.getId(),
                patient.getName(),
                patient.getSurname(),
                patient.getSecondName(),
                patient.getInn());
    }
}
