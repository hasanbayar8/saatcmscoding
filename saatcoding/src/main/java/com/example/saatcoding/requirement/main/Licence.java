package com.example.saatcoding.requirement.main;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Licence {
    @Id
    Long id;

    @ManyToMany(mappedBy ="licences")
    Set<Content> contents;
    @SequenceGenerator(
            name = "licence_sequence",
            sequenceName = "licence_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "licenceSequence"
    )
    private String name;
    private LocalDate startTime;
    private LocalDate endTime;

    public Licence(Long id,
                   String name,
                   LocalDate startTime,
                   LocalDate endTime) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Licence(String name,
                   LocalDate startTime,
                   LocalDate endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Licence() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Licence{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
