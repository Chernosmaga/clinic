package com.clinic.patient.service;

import com.clinic.patient.dto.PatientDto;

public interface PatientService {
    PatientDto add(PatientDto patient);
    PatientDto update(Long patientId, PatientDto patient);
    PatientDto get(Long patientId);
    void updateIsActive(Long patientId, Boolean isActive);
}
