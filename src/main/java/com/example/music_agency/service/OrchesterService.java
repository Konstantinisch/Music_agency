package com.example.music_agency.service;

import com.example.music_agency.dto.OrchesterDto;

import java.util.List;

public interface OrchesterService {
    List<OrchesterDto> getAllOrchesters();
    OrchesterDto getOrchesterById(Integer id);
}
