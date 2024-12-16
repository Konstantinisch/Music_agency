package com.example.music_agency.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PianistDto {
    private int pianistId;
    private String name;
    private String nameOfProgram;
}
