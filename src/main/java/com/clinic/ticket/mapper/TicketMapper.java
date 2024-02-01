package com.clinic.ticket.mapper;

import com.clinic.doctor.mapper.DoctorMapper;
import com.clinic.patient.mapper.PatientMapper;
import com.clinic.ticket.dto.TicketDto;
import com.clinic.ticket.dto.TicketShortDto;
import com.clinic.ticket.model.Ticket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TicketMapper {
    private final DoctorMapper doctorMapper;
    private final PatientMapper patientMapper;

    public TicketShortDto toTicketShortDto(Ticket ticket) {
        return new TicketShortDto(
                ticket.getId(),
                doctorMapper.toDoctorShortDto(ticket.getDoctor()),
                ticket.getStart(),
                ticket.getEnd());
    }

    public TicketDto toTicketDto(Ticket ticket) {
        return new TicketDto(
                ticket.getId(),
                doctorMapper.toDoctorShortDto(ticket.getDoctor()),
                patientMapper.toPatientShortDto(ticket.getPatient()),
                ticket.getStart(),
                ticket.getEnd());
    }
}
