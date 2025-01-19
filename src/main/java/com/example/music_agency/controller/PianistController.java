package com.example.music_agency.controller;

import com.example.music_agency.dto.PianistDto;
import com.example.music_agency.service.PianistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pianists")
@RequiredArgsConstructor
public class PianistController {

    private final PianistService pianistService;

    @GetMapping("/")
    public List<PianistDto> getPianists() {
        return pianistService.getAllPianists();
    }

    @GetMapping(value = "/{id}")
    public PianistDto getPianistById(@PathVariable Integer id) {
        return pianistService.getPianistById(id);
    }

    @PutMapping
    public PianistDto createPianist(@RequestBody PianistDto pianistDto) {
        return pianistService.createPianist(pianistDto);
    }

    @PostMapping
    public PianistDto updatePianist(@RequestBody PianistDto pianistDto) {
        return pianistService.updatePianist(pianistDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePianist(@PathVariable Integer id) {
        pianistService.deletePianist(id);
    }
}
