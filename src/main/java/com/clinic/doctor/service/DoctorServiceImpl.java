package com.clinic.doctor.service;

import com.clinic.doctor.dto.DoctorDto;
import com.clinic.doctor.mapper.DoctorMapper;
import com.clinic.doctor.model.Doctor;
import com.clinic.doctor.repository.DoctorRepository;
import com.clinic.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorDto add(DoctorDto doctor) {
        Doctor newDoctor = doctorMapper.toDoctor(doctor);
        newDoctor.setUuid(UUID.randomUUID().toString());
        newDoctor.setIsActive(true);
        newDoctor.setWorkStartTime(LocalDate.now());
        Doctor saved = doctorRepository.save(newDoctor);
        log.info("Добавлена информация о докторе: {}", saved);
        return doctorMapper.toDoctorDto(saved);
    }

    @Override
    public DoctorDto update(Long doctorId, DoctorDto doctor) {
        Doctor thisDoctor = find(doctorId);
        if (doctor.getName() != null) {
            thisDoctor.setName(doctor.getName());
        }
        if (doctor.getSurname() != null) {
            thisDoctor.setSurname(doctor.getSurname());
        }
        if (doctor.getSecondName() != null) {
            thisDoctor.setSecondName(doctor.getSecondName());
        }
        if (doctor.getBirthday() != null) {
            thisDoctor.setBirthday(doctor.getBirthday());
        }
        if (doctor.getLicense() != null) {
            thisDoctor.setLicense(doctor.getLicense());
        }
        Doctor updated = doctorRepository.save(thisDoctor);
        log.info("Обновлена информация о докторе: {}", updated);
        return doctorMapper.toDoctorDto(updated);
    }

    @Override
    public DoctorDto get(Long doctorId) {
        Doctor returned = find(doctorId);
        log.info("Возвращены данные о докторе: {}", returned);
        return doctorMapper.toDoctorDto(returned);
    }

    @Override
    public void updateIsActive(Long doctorId, Boolean isActive) {
        Doctor found = find(doctorId);
        found.setIsActive(isActive);
        Doctor updated = doctorRepository.save(found);
        log.info("Обновлены данные о докторе: {}", updated);
    }

    private Doctor find(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException("Данные не найдены"));
    }
}
