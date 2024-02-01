package com.clinic.ticket.dto;

import com.clinic.doctor.dto.DoctorShortDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketShortDto {
    private Long id;
    private DoctorShortDto doctor;
    private LocalDateTime start;
    private LocalDateTime end;
}
