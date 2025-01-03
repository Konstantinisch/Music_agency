package com.example.music_agency.service.impl;

//import com.example.music_agency.exception.ManagerDoesntExistException;
//import com.example.music_agency.exception.error_messages.ErrorMessage;

import com.example.music_agency.dto.ManagerDto;
import com.example.music_agency.entity.ManagerEntity;
import com.example.music_agency.exception.ManagerDoesntExistException;
import com.example.music_agency.repository.ManagerRepository;
import com.example.music_agency.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    public final ManagerRepository managerRepository;

    @Override
    public List<ManagerDto> getAllManagers() {
      List<ManagerEntity> managerEntities = managerRepository.findAll();
        return managerEntities.stream()
                .map(entity -> new ManagerDto(entity.getManagerId(), entity.getName(), entity.getPercentOfGage()))
                .collect(Collectors.toList());
    }

    @Override
    public ManagerEntity getManagerById(Integer id) {
        Optional<ManagerEntity> optionalManager = Optional.ofNullable(managerRepository.findById(id)
                .orElseThrow(() -> new ManagerDoesntExistException("manager not exists")));

        System.out.println("Manager: " + optionalManager.get());
        ManagerEntity manager = optionalManager.get();
        return manager;
    }
}