package com.example.music_agency.controller;

import com.example.music_agency.dto.ManagerDto;
import com.example.music_agency.entity.ManagerEntity;
import com.example.music_agency.service.ManagerService;
import com.example.music_agency.service.impl.ManagerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/manager")
@RequiredArgsConstructor
public class ManagerController {


    public final ManagerService managerService;
    private final ManagerServiceImpl managerServiceImpl;


    @GetMapping
    public List<ManagerDto> getAllManagers() {
        return managerService.getAllManagers();
    }

    // почему так работает странно?
    @GetMapping("/{id}")
    public ManagerEntity getManagerById(@PathVariable(name = "id") Integer id) {
        return managerService.getManagerById(id);
    }
}
