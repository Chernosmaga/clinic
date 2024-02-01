package com.clinic.doctor.model;

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
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    private String surname;
    @Column(name  = "second_name")
    private String secondName;
    @Column(name = "is_active")
    private Boolean isActive;
    @Column(name = "work_start_time")
    private LocalDate workStartTime;
    private LocalDate birthday;
    private String license;

    public Doctor(String name, String surname, String secondName, LocalDate birthday, String license) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.birthday = birthday;
        this.license = license;
    }
}
