package com.example.music_agency.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "pianists")
public class Pianist {


    @Id
    @Column (name = "pianist_id")
    private int pianistId;

    @Column(name = "name")
    private String name;

    @Column(name = "name_of_program")
    private String nameOfProgram;

    @Column(name = "gage")
    private int gage;

    @Column(name = "duration_of_concert_in_min")
    private int durationOfConcertInMin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pianist pianist = (Pianist) o;
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
