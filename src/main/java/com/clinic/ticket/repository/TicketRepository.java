package com.clinic.ticket.repository;

import com.clinic.doctor.model.Doctor;
import com.clinic.patient.model.Patient;
import com.clinic.ticket.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Page<Ticket> findAllByDoctorAndStartAndIsFree(Doctor doctor,
                                                               LocalDateTime start,
                                                               Boolean isFree,
                                                               Pageable page);

    List<Ticket> findAllByPatient(Patient patient);
}
