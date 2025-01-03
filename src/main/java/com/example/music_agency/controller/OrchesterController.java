package com.example.music_agency.controller;

import com.example.music_agency.dto.OrchesterDto;
import com.example.music_agency.service.OrchesterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/orchesters")
@RequiredArgsConstructor
public class OrchesterController {

    public final OrchesterService orchesterService;

    @GetMapping(value = "/{id}")
    public OrchesterDto getOrchesterById(@PathVariable Integer id) {
        return orchesterService.getOrchesterById(id);
    }
}

