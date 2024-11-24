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
@Table(name = "managers")
public class Manager {


    @Id
    @Column(name = "manager_id")
    private int managerId;

    @Column(name = "name")
    private String name;

    @Column(name = "percent_of_gage")
    private int percentOfGage;

    private Orchester orchester;

    private Pianist pianist;



    @Override
    public String toString() {
        return "Manager{" +
                "managerId=" + managerId +
                ", name='" + name + '\'' +
                ", percentOfGage=" + percentOfGage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return managerId == manager.managerId && percentOfGage == manager.percentOfGage && Objects.equals(name, manager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, name, percentOfGage);
    }
}
