package com.example.music_agency.service.impl;

import com.example.music_agency.dto.PianistDto;
import com.example.music_agency.entity.PianistEntity;
import com.example.music_agency.exception.PianistDoesntExistException;
import com.example.music_agency.repository.PianistRepository;
import com.example.music_agency.service.PianistService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PianistServiceImpl implements PianistService {

    private final PianistRepository pianistRepository;


    @Override
    public List<PianistDto> getAllPianists() {
        List<PianistEntity> pianists = pianistRepository.findAll();
        return pianists.stream()
                .map(en -> new PianistDto(en.getPianistId(), en.getName(), en.getNameOfProgram()))
                .collect(Collectors.toList());
    }

    @Override
    public PianistDto getPianistById(Integer id) {
        PianistEntity pianistentity = pianistRepository.findById(id).orElseThrow(() -> new RuntimeException("Pianist" +
                " not found"));
        return new PianistDto(pianistentity.getPianistId(), pianistentity.getName(), pianistentity.getNameOfProgram());
    }

    @Override
    public PianistDto createPianist(PianistDto pianistDto) {
        PianistEntity pianistEntity = new PianistEntity(null, pianistDto.getName(),pianistDto.getNameOfProgram());
        PianistEntity savedPianist = pianistRepository.save(pianistEntity);
        return new PianistDto(savedPianist.getPianistId(), savedPianist.getName(), savedPianist.getNameOfProgram());
    }

    @Override
    public PianistDto updatePianist(PianistDto pianistDto) {
        PianistEntity pianistEntity = new PianistEntity(null, pianistDto.getName(), pianistDto.getNameOfProgram());
        PianistEntity savedPianist = pianistRepository.save(pianistEntity);
        return new PianistDto(savedPianist.getPianistId(), savedPianist.getName(), savedPianist.getNameOfProgram());
    }

    @Override
    public void deletePianist(Integer id) {
        PianistEntity pianistEntity = pianistRepository.findById(id).orElseThrow(() -> new PianistDoesntExistException
                ("Pianist " + id + " not found"));
        pianistRepository.delete(pianistEntity);
    }
}
