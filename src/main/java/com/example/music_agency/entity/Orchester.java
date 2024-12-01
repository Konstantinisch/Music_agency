package com.example.music_agency.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "orchesters")
public class Orchester {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orchester_id")
    private int orchesterId;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_people")
    private int numberOfPeople;

    @Column(name = "name_of_program")
    private String nameOfProgram;

    @Column(name = "gage")
    private int gage;

    @Column(name = "duration_of_concert_in_min")
    private int durationOfConcertInMin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id_fk", referencedColumnName = "manager_id")
    private Manager manager;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orchester orchester = (Orchester) o;
        return orchesterId == orchester.orchesterId && numberOfPeople == orchester.numberOfPeople && gage == orchester.gage && durationOfConcertInMin == orchester.durationOfConcertInMin && Objects.equals(name, orchester.name) && Objects.equals(nameOfProgram, orchester.nameOfProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orchesterId, name, numberOfPeople, nameOfProgram, gage, durationOfConcertInMin);
    }

    @Override
    public String toString() {
        return "Orchester{" +
                "orchesterId=" + orchesterId +
                ", name='" + name + '\'' +
                ", numberOfPeople=" + numberOfPeople +
                ", nameOfProgram='" + nameOfProgram + '\'' +
                ", gage=" + gage +
                ", durationOfConcertInMin=" + durationOfConcertInMin +
                '}';
    }
}
