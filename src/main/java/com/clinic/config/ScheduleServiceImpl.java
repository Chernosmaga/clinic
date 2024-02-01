package com.clinic.config;

import com.clinic.ticket.dto.TicketShortDto;
import com.clinic.ticket.service.TicketService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final TicketService ticketService;

    @WebMethod
    public TicketShortDto createSchedule(@WebParam(name = "doctor_id") Long doctorId,
                                         @WebParam(name = "start") LocalDateTime start,
                                         @WebParam(name = "end") LocalDateTime end) {
        return ticketService.createSchedule(doctorId, start, end);
    }
}