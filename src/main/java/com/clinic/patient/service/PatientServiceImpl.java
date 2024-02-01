package com.clinic.patient.service;

import com.clinic.exception.NotFoundException;
import com.clinic.patient.dto.PatientDto;
import com.clinic.patient.mapper.PatientMapper;
import com.clinic.patient.model.Patient;
import com.clinic.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;


    @Override
    public PatientDto add(PatientDto patient) {
        Patient newPatient = patientMapper.toPatient(patient);
        newPatient.setUuid(UUID.randomUUID().toString());
        newPatient.setIsActive(true);
        Patient saved = patientRepository.save(newPatient);
        log.info("Добавлена информация о пациенте: {}", saved);
        return patientMapper.toPatientDto(saved);
    }

    @Override
    public PatientDto update(Long patientId, PatientDto patient) {
        Patient found = find(patientId);
        if (patient.getName() != null) {
            found.setName(patient.getName());
        }
        if (patient.getSurname() != null) {
            found.setSurname(patient.getSurname());
        }
        if (patient.getSecondName() != null) {
            found.setSecondName(patient.getSecondName());
        }
        if (patient.getBirthday() != null) {
            found.setBirthday(patient.getBirthday());
        }
        if (patient.getInn() != null) {
            found.setInn(patient.getInn());
        }
        Patient updated = patientRepository.save(found);
        log.info("Обновлена информация о пациенте: {}", updated);
        return patientMapper.toPatientDto(updated);
    }

    @Override
    public PatientDto get(Long patientId) {
        Patient found = find(patientId);
        log.info("Возвращена информация о пациенте: {}", found);
        return patientMapper.toPatientDto(found);
    }

    @Override
    public void updateIsActive(Long patientId, Boolean isActive) {
        Patient found = find(patientId);
        found.setIsActive(isActive);
        Patient updated = patientRepository.save(found);
        log.info("Обновлена информация о пациенте: {}", updated);
    }

    private Patient find(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new NotFoundException("Данные не найдены"));
    }
}
