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
    public List<ManagerEntity> getAllManagers() {
      List<ManagerEntity> managerEntities = managerRepository.findAll();
        return managerEntities.stream()
                .map(entity -> new ManagerEntity(entity.getManagerId(), entity.getName(), entity.getPercentOfGage()))
                .collect(Collectors.toList());
    }
//    @Override
//    public List<ManagerEntity> getAllManagers() {
//        List<ManagerEntity> managerEntities = managerRepository.findAll();
//
//        // После получения данных из репозитория
//        managerEntities.forEach(entity ->
//                System.out.println("Before Mapping: ID=" + entity.getManagerId() +
//                        ", Name=" + entity.getName() +
//                        ", Percent=" + entity.getPercentOfGage())
//        );
//
//        List<ManagerEntity> mappedEntities = managerEntities.stream()
//                .map(entity -> new ManagerEntity(entity.getManagerId(), entity.getName(), entity.getPercentOfGage()))
//                .collect(Collectors.toList());
//
//        // После маппинга
//        mappedEntities.forEach(mappedEntity ->
//                System.out.println("After Mapping: ID=" + mappedEntity.getManagerId() +
//                        ", Name=" + mappedEntity.getName() +
//                        ", Percent=" + mappedEntity.getPercentOfGage())
//        );
//
//        return mappedEntities;
//    }


    @Override
    public ManagerEntity getManagerById(Integer id) {
        Optional<ManagerEntity> optionalManager = Optional.ofNullable(managerRepository.findById(id)
                .orElseThrow(() -> new ManagerDoesntExistException("manager not exists")));

        System.out.println("Manager: " + optionalManager.get());
        ManagerEntity manager = optionalManager.get();
        return manager;
    }

    @Override
    public ManagerDto createManager(ManagerDto managerDto) {
        ManagerEntity managerEntity = new ManagerEntity(null, managerDto.getName(), managerDto.getPercentOfGage());
        ManagerEntity savedManagerEntity = managerRepository.save(managerEntity);
        return new ManagerDto(savedManagerEntity.getManagerId(), savedManagerEntity.getName(), savedManagerEntity.
                getPercentOfGage());
    }

    @Override
    public ManagerDto updateManager(ManagerDto managerDto) {
        ManagerEntity managerEntity = new ManagerEntity(null, managerDto.getName(), managerDto.getPercentOfGage());
        ManagerEntity updatedManagerEntity = managerRepository.save(managerEntity);
        return new ManagerDto(updatedManagerEntity.getManagerId(), updatedManagerEntity.getName(),
                updatedManagerEntity.getPercentOfGage());
    }

    @Override
    public void deleteManager(Integer id) {
        ManagerEntity managerEntity = managerRepository.findById(id).orElseThrow(() -> new ManagerDoesntExistException
                ("manager not exists"));
        managerRepository.delete(managerEntity);
    }


}