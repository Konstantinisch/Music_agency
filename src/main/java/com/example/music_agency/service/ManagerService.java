package com.example.music_agency.service;

import com.example.music_agency.dto.ManagerDto;
import com.example.music_agency.entity.ManagerEntity;

import java.util.List;

public interface ManagerService {
    List<ManagerDto> getAllManagers();

    ManagerEntity getManagerById(Integer id);

    ManagerDto createManager(ManagerDto managerDto);

    ManagerDto updateManager(ManagerDto managerDto);

    void deleteManager(Integer id);

}
