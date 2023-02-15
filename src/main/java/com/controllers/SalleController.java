package com.controllers;

import com.dtos.SalleDto;
import com.services.impl.SalleServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleServiceImpl salleService;

    public SalleController(SalleServiceImpl salleService) {
        this.salleService = salleService;
    }

    /**
     * <p>Get all dogs in the system</p>
     * @return List<SalleDto>
     */
    @GetMapping
    public List<SalleDto> getSalles() {
        return salleService.getAllSalles();
    }

    /**
     * Method to get the dog based on the ID
     */
    @GetMapping("/{id}")
    public SalleDto getSalle(@PathVariable Long id){
        return salleService.getSalleById(id);
    }

    /**
     * Create a new Dog in the system
     */
    @PostMapping
    public SalleDto saveSalle(final @RequestBody SalleDto salleDto){
        return salleService.saveSalle(salleDto);
    }

    /**
     * Delete a dog by it's id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean deleteSalle(@PathVariable Long id){
        return salleService.deleteSalle(id);
    }

}
