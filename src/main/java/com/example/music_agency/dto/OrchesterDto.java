package com.example.music_agency.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrchesterDto {

    private Integer orchesterId;
    private String name;
    private int numberOfPeople;
    private String nameOfProgram;



}
