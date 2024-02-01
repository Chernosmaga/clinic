package com.clinic.patient.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    private String surname;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "is_active")
    private Boolean isActive;
    private LocalDate birthday;
    private String inn;

    public Patient(String name, String surname, String secondName, LocalDate birthday, String inn) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.birthday = birthday;
        this.inn = inn;
    }
}
