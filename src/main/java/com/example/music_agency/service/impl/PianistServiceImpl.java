package com.example.music_agency.service.impl;

import com.example.music_agency.dto.PianistDto;
import com.example.music_agency.entity.PianistEntity;
import com.example.music_agency.repository.PianistRepository;
import com.example.music_agency.service.PianistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PianistServiceImpl implements PianistService {

    private final PianistRepository pianistRepository;


    @Override
    public PianistDto getPianistById(Integer id) {
        PianistEntity pianistentity = pianistRepository.findById(id).orElseThrow(() -> new RuntimeException("Pianist" +
                " not found"));
        return new PianistDto(pianistentity.getPianistId(), pianistentity.getName(), pianistentity.getNameOfProgram());
    }
}
