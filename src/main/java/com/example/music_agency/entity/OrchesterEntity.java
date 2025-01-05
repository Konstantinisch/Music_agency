package com.example.music_agency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orchesters")
public class OrchesterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orchester_id")
    private Integer orchesterId;

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
    private ManagerEntity manager;

    public OrchesterEntity(Object o, String name, String nameOfProgram, int numberOfPeople) {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrchesterEntity orchesterEntity = (OrchesterEntity) o;
        return orchesterId == orchesterEntity.orchesterId && numberOfPeople == orchesterEntity.numberOfPeople &&
                gage == orchesterEntity.gage && durationOfConcertInMin == orchesterEntity.durationOfConcertInMin &&
                Objects.equals(name, orchesterEntity.name) && Objects.equals(nameOfProgram, orchesterEntity.nameOfProgram);
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
