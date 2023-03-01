package com.controllers;

import com.dtos.SoireeDto;
import com.services.impl.SoireeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soirees")
public class SoireeController {

    private final SoireeServiceImpl SoireeService;

    public SoireeController(SoireeServiceImpl SoireeService) {
        this.SoireeService = SoireeService;
    }

    /**
     * <p>Get all soiree in the system</p>
     * @return List<SoireeDto>
     */
    @GetMapping
    public List<SoireeDto> getSoirees() {
        return SoireeService.getAllSoirees();
    }

    /**
     * Method to get the soiree based on the ID
     */
    @GetMapping("/{id}")
    public SoireeDto getSoiree(@PathVariable Long id){
        return SoireeService.getSoireeById(id);
    }

    /**
     * Create a new Dog in the system
     */
    @PostMapping
    public SoireeDto saveSoiree(final @RequestBody SoireeDto SoireeDto){
        return SoireeService.saveSoiree(SoireeDto);
    }

    /**
     * Delete a dog by it's id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteSoiree(@PathVariable Long id){
        return SoireeService.deleteSoiree(id);
    }

}
