package com.example.music_agency.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "managers")
public class ManagerEntity {

    @Id
    @Column(name = "manager_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerId;

    @Column(name = "name")
    private String name;

    @Column(name = "percent_of_gage")
    private int percentOfGage;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<OrchesterEntity> orchesterEntity;

    @JsonIgnore
    @OneToMany(mappedBy = "manager")
    private List<PianistEntity> pianist;

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
        ManagerEntity manager = (ManagerEntity) o;
        return managerId == manager.managerId && percentOfGage == manager.percentOfGage && Objects.equals(name, manager.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(managerId, name, percentOfGage);
    }
}
