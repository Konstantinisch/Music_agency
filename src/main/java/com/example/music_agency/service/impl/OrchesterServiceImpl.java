package com.example.music_agency.service.impl;

import com.example.music_agency.dto.OrchesterDto;
import com.example.music_agency.entity.OrchesterEntity;
import com.example.music_agency.repository.OrchesterRepository;
import com.example.music_agency.service.OrchesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrchesterServiceImpl implements OrchesterService {

    private final OrchesterRepository orchesterRepository;


    @Override
    public OrchesterDto getOrchesterById(Integer id) {
    OrchesterEntity orchesterEntity = orchesterRepository.findById(id).orElse(new OrchesterEntity());
        return new OrchesterDto(orchesterEntity.getOrchesterId(), orchesterEntity.getName(), orchesterEntity.getNumberOfPeople(),
                orchesterEntity.getNameOfProgram());

    }


}
