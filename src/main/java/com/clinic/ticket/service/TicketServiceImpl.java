package com.clinic.ticket.service;

import com.clinic.doctor.model.Doctor;
import com.clinic.doctor.repository.DoctorRepository;
import com.clinic.exception.NotFoundException;
import com.clinic.patient.model.Patient;
import com.clinic.patient.repository.PatientRepository;
import com.clinic.ticket.dto.TicketDto;
import com.clinic.ticket.dto.TicketShortDto;
import com.clinic.ticket.mapper.TicketMapper;
import com.clinic.ticket.model.Ticket;
import com.clinic.ticket.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Slf4j
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final TicketMapper ticketMapper;

    @Override
    public TicketDto add(Long patientId, Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new NotFoundException("Слот не найден"));
        ticket.setPatient(findPatientById(patientId));
        ticket.setIsFree(false);
        Ticket saved = ticketRepository.save(ticket);
        log.info("Пациент записался на приём: {}", saved);
        return ticketMapper.toTicketDto(ticket);
    }

    @Override
    public List<TicketShortDto> getAvailable(Long doctorId, LocalDateTime date, int from, int size) {
        PageRequest pageRequest = PageRequest.of(from, size, DESC, "start");
        Doctor doctor = findDoctor(doctorId);
        List<TicketShortDto> available =
                ticketRepository.findAllByDoctorAndStartAndIsFree(doctor, date, true, pageRequest)
                .stream().map(ticketMapper::toTicketShortDto).collect(Collectors.toList());
        log.info("Возвращен список доступный слотов: {}", available);
        return available;
    }

    @Override
    public List<TicketShortDto> getByPatient(Long patientId, String uuid) {
        Patient patient = patientId == null ? patientRepository.findByUuid(uuid) : findPatientById(patientId);
        List<TicketShortDto> appointments = ticketRepository.findAllByPatient(patient)
                .stream().map(ticketMapper::toTicketShortDto).collect(Collectors.toList());
        log.info("Возвращены все приемы пациента {}: {}", patient, appointments);
        return appointments;
    }

    @Override
    public TicketShortDto createSchedule(Long doctorId, LocalDateTime start, LocalDateTime end) {
        Doctor doctor = findDoctor(doctorId);
        Ticket ticket = new Ticket();
        ticket.setPatient(null);
        ticket.setIsFree(true);
        ticket.setDoctor(doctor);
        ticket.setStart(start);
        ticket.setEnd(end);
        Ticket saved = ticketRepository.save(ticket);
        log.info("Добавлен новый слот в расписании доктора {}: {}", doctor, saved);
        return ticketMapper.toTicketShortDto(saved);
    }

    private Patient findPatientById(Long patientId) {
        return patientRepository.findById(patientId).orElseThrow(() -> new NotFoundException("Пациент не найден"));
    }

    private Doctor findDoctor(Long doctorId) {
        return doctorRepository.findById(doctorId)
                .orElseThrow(() -> new NotFoundException("Информация о докторе не найдена"));
    }
}
