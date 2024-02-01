package com.clinic.doctor.mapper;

import com.clinic.doctor.dto.DoctorDto;
import com.clinic.doctor.dto.DoctorShortDto;
import com.clinic.doctor.model.Doctor;
import org.springframework.stereotype.Component;

@Component
public class DoctorMapper {

    public Doctor toDoctor(DoctorDto doctor) {
        return new Doctor(
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSecondName(),
                doctor.getBirthday(),
                doctor.getLicense());
    }

    public DoctorDto toDoctorDto(Doctor doctor) {
        return new DoctorDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSecondName(),
                doctor.getBirthday(),
                doctor.getLicense());
    }

    public DoctorShortDto toDoctorShortDto(Doctor doctor) {
        return new DoctorShortDto(
                doctor.getId(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getSecondName());
    }
}
