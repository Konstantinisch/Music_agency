package com.example.music_agency.controller;

import com.example.music_agency.dto.OrchesterDto;
import com.example.music_agency.service.OrchesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/orchesters")
@RequiredArgsConstructor
public class OrchesterController {

    public final OrchesterService orchesterService;

    @GetMapping("/")
    public List<OrchesterDto> getAllOrchesters() {
        return orchesterService.getAllOrchesters();
    }

    @GetMapping(value = "/{id}")
    public OrchesterDto getOrchesterById(@PathVariable Integer id) {
        return orchesterService.getOrchesterById(id);
    }

    @PutMapping
    public OrchesterDto createOrchester(@RequestBody OrchesterDto orchesterDto) {
        return orchesterService.createOrchester(orchesterDto);
    }

    @PostMapping
    public OrchesterDto updateOrchester(@RequestBody OrchesterDto orchesterDto) {
        return orchesterService.updateOrchester(orchesterDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOrchester(@PathVariable Integer id) {
        orchesterService.deleteOrchester(id);
    }
}

