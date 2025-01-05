package com.example.music_agency.service.impl;

import com.example.music_agency.dto.OrchesterDto;
import com.example.music_agency.entity.OrchesterEntity;
import com.example.music_agency.exception.OrchesterDoesntExistException;
import com.example.music_agency.repository.OrchesterRepository;
import com.example.music_agency.service.OrchesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrchesterServiceImpl implements OrchesterService {

    private final OrchesterRepository orchesterRepository;


    @Override
    public List<OrchesterDto> getAllOrchesters() {
        List<OrchesterEntity> orchesterEntities = orchesterRepository.findAll();
        return orchesterEntities.stream()
                .map(en ->new OrchesterDto(en.getOrchesterId(), en.getName(), en.getNumberOfPeople(),
                        en.getNameOfProgram()))
                .collect(Collectors.toList());
    }

    @Override
    public OrchesterDto getOrchesterById(Integer id) {
    OrchesterEntity orchesterEntity = orchesterRepository.findById(id).orElse(new OrchesterEntity());
        return new OrchesterDto(orchesterEntity.getOrchesterId(), orchesterEntity.getName(), orchesterEntity.getNumberOfPeople(),
                orchesterEntity.getNameOfProgram());

    }

    @Override
    public OrchesterDto createOrchester(OrchesterDto orchesterDto) {
        OrchesterEntity orchesterEntity = new OrchesterEntity(null, orchesterDto.getName(),
                orchesterDto.getNameOfProgram(),orchesterDto.getNumberOfPeople());
        OrchesterEntity savedOrchesterEntity = orchesterRepository.save(orchesterEntity);
        return new OrchesterDto(savedOrchesterEntity.getOrchesterId(), savedOrchesterEntity.getName(),
                savedOrchesterEntity.getNumberOfPeople(), savedOrchesterEntity.getNameOfProgram());
    }

    @Override
    public OrchesterDto updateOrchester(OrchesterDto orchesterDto) {
        OrchesterEntity orchesterEntity = new OrchesterEntity(null, orchesterDto.getName(),
                orchesterDto.getNameOfProgram(), orchesterDto.getNumberOfPeople());
        OrchesterEntity savedOrchesterEntity = orchesterRepository.save(orchesterEntity);
        return new OrchesterDto(savedOrchesterEntity.getOrchesterId(), savedOrchesterEntity.getName(),
                savedOrchesterEntity.getNumberOfPeople(), savedOrchesterEntity.getNameOfProgram());
    }

    @Override
    public void deleteOrchester(Integer id) {
        OrchesterEntity orchesterEntity = orchesterRepository.findById(id).orElseThrow(() -> new
                OrchesterDoesntExistException("Orchester doesn't exist"));
        orchesterRepository.delete(orchesterEntity);
    }


}
