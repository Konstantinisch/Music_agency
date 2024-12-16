package com.example.music_agency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "pianists")
public class PianistEntity {

    @Id
    @Column (name = "pianist_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pianistId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_of_program")
    private String nameOfProgram;

    @Column(name = "gage")
    private int gage;

    @Column(name = "duration_of_concert_in_min")
    private int durationOfConcertInMin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mp_id_fk", referencedColumnName = "manager_id")
    private ManagerEntity manager;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PianistEntity pianist = (PianistEntity) o;
        return pianistId == pianist.pianistId && gage == pianist.gage && durationOfConcertInMin == pianist.durationOfConcertInMin && Objects.equals(name, pianist.name) && Objects.equals(nameOfProgram, pianist.nameOfProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pianistId, name, nameOfProgram, gage, durationOfConcertInMin);
    }

    @Override
    public String toString() {
        return "Pianist{" +
                "pianistId=" + pianistId +
                ", name='" + name + '\'' +
                ", nameOfProgram='" + nameOfProgram + '\'' +
                ", gage=" + gage +
                ", durationOfConcertInMin=" + durationOfConcertInMin +
                '}';
    }
}
