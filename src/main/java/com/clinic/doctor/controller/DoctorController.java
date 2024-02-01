package com.clinic.doctor.controller;

import com.clinic.doctor.dto.DoctorDto;
import com.clinic.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/admin/doctors")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping
    @ResponseStatus(CREATED)
    public DoctorDto add(@RequestBody DoctorDto doctor) {
        return doctorService.add(doctor);
    }

    @PutMapping("/{doctorId}")
    public DoctorDto update(@PathVariable Long doctorId, @RequestBody DoctorDto doctor) {
        return doctorService.update(doctorId, doctor);
    }

    @GetMapping("/{doctorId}")
    public DoctorDto get(@PathVariable Long doctorId) {
        return doctorService.get(doctorId);
    }

    @PatchMapping("/{doctorId}")
    @ResponseStatus(NO_CONTENT)
    public void updateIsActive(@PathVariable Long doctorId, @RequestParam(defaultValue = "false") Boolean isActive) {
        doctorService.updateIsActive(doctorId, isActive);
    }
}
