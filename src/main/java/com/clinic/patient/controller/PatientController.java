package com.clinic.patient.controller;

import com.clinic.patient.dto.PatientDto;
import com.clinic.patient.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/admin/patients")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    @ResponseStatus(CREATED)
    public PatientDto add(@RequestBody PatientDto patient) {
        return patientService.add(patient);
    }

    @PutMapping("/{patientId}")
    public PatientDto update(@PathVariable Long patientId, @RequestBody PatientDto patient) {
        return patientService.update(patientId, patient);
    }

    @GetMapping("/{patientId}")
    public PatientDto get(@PathVariable Long patientId) {
        return patientService.get(patientId);
    }

    @PatchMapping("/{patientId}")
    @ResponseStatus(NO_CONTENT)
    public void updateIsActive(@PathVariable Long patientId, @RequestParam(defaultValue = "false") Boolean isActive) {
        patientService.updateIsActive(patientId, isActive);
    }
}
