package com.clinic.ticket.service;

import com.clinic.ticket.dto.TicketDto;
import com.clinic.ticket.dto.TicketShortDto;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketService {
    TicketDto add(Long patientId, Long ticketId);

    List<TicketShortDto> getAvailable(Long doctorId, LocalDateTime date, int from, int size);

    List<TicketShortDto> getByPatient(Long patientId, String uuid);

    TicketShortDto createSchedule(Long doctorId, LocalDateTime start, LocalDateTime end);
}
