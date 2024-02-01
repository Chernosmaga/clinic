package com.clinic.doctor.service;

import com.clinic.doctor.dto.DoctorDto;

public interface DoctorService {
    DoctorDto add(DoctorDto doctor);
    DoctorDto update(Long doctorId, DoctorDto doctor);
    DoctorDto get(Long doctorId);
    void updateIsActive(Long doctorId, Boolean isActive);
}
