package com.openhospital.productservice.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "MEDICAL_SERVICE")
public class MedicalService {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HEALTH_ID")
    private Health health;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Instant getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Instant insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}