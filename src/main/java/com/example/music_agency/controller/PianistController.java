package com.example.music_agency.controller;

import com.example.music_agency.dto.PianistDto;
import com.example.music_agency.service.PianistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pianists")
@RequiredArgsConstructor
public class PianistController {

    private final PianistService pianistService;

    @GetMapping(value = "/{id}")
    public PianistDto getPianistById(@PathVariable Integer id) {
        return pianistService.getPianistById(id);
    }
}
