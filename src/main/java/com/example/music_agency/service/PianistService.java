package com.example.music_agency.service;

import com.example.music_agency.dto.PianistDto;

import java.util.List;


public interface PianistService {
    List<PianistDto> getAllPianists();

    PianistDto getPianistById(Integer id);

    PianistDto createPianist(PianistDto pianistDto);

    PianistDto updatePianist(PianistDto pianistDto);

    void deletePianist(Integer id);
}
