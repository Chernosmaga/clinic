package com.clinic.ticket.dto;

import com.clinic.doctor.dto.DoctorShortDto;
import com.clinic.patient.dto.PatientShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {
    private Long id;
    private DoctorShortDto doctor;
    private PatientShortDto patient;
    private LocalDateTime start;
    private LocalDateTime end;
}
