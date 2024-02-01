package com.clinic.ticket.controller;

import com.clinic.ticket.dto.TicketDto;
import com.clinic.ticket.dto.TicketShortDto;
import com.clinic.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/users/tickets")
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @PostMapping("/{patientId}")
    @ResponseStatus(CREATED)
    public TicketDto add(@PathVariable Long patientId, @RequestParam Long ticketId) {
        return ticketService.add(patientId, ticketId);
    }

    @GetMapping("/{doctorId}")
    public List<TicketShortDto> getAvailable(@PathVariable Long doctorId,
                                             @RequestParam LocalDateTime dateTime,
                                             @RequestParam(defaultValue = "0") int from,
                                             @RequestParam(defaultValue = "10") int size) {
        return ticketService.getAvailable(doctorId, dateTime, from, size);
    }

    @GetMapping
    public List<TicketShortDto> getByPatient(@RequestParam(required = false) Long patientId,
                                             @RequestParam(required = false) String uuid) {
        return ticketService.getByPatient(patientId, uuid);
    }

}
