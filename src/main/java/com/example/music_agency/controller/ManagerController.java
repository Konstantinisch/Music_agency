package com.example.music_agency.controller;

import com.example.music_agency.dto.ManagerDto;
import com.example.music_agency.entity.ManagerEntity;
import com.example.music_agency.service.ManagerService;
import com.example.music_agency.service.impl.ManagerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/manager")
@RequiredArgsConstructor
public class ManagerController {


    public final ManagerService managerService;



    @GetMapping("/")
    public List<ManagerEntity> getAllManagers() {
        return managerService.getAllManagers();
    }

    // почему так работает странно?
    @GetMapping("/{id}")
    public ManagerEntity getManagerById(@PathVariable Integer id) {
        return managerService.getManagerById(id);
    }

    @PutMapping
    public ManagerDto createManager(@RequestBody ManagerDto managerDto) {
        return managerService.createManager(managerDto);
    }

    @PostMapping
    public ManagerDto updateManager(@RequestBody ManagerDto managerDto) {
        return managerService.updateManager(managerDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteManager(@PathVariable Integer id) {
        managerService.deleteManager(id);
    }
}
