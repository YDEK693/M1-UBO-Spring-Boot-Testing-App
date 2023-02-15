package com.services.impl;



import com.dtos.SalleDto;
import com.entities.Concert;
import com.entities.Salle;
import com.repositories.SalleRepository;
import com.services.SalleService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("SalleService")
public class SalleServiceImpl implements SalleService {
    private final SalleRepository salleRepository;

    public SalleServiceImpl(SalleRepository salleRepository){
        this.salleRepository = salleRepository;
    }

    @Override
    public List<SalleDto> getAllSalles() {
        List<SalleDto> salleDtos = new ArrayList<>();
        List<Salle> salles = salleRepository.findAll();
        salles.forEach(dog -> {
            salleDtos.add(salleEntityToDto(dog));
        });
        return salleDtos;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        // Converts the dto to the dog entity
        Salle salle = SalleDtoToEntity(salleDto);
        // Save the dog entity
        salle = salleRepository.save(salle);
        // Return the new dto
        return salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long salleId) {
        Salle concert = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("salle not found"));
        return salleEntityToDto(concert);
    }

    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    /**
     * Map salle dto to salle entity
     */
    private SalleDto salleEntityToDto(Salle salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getId());
        salleDto.setNom(salle.getNom());
        salleDto.setCapacite(salle.getCapacite());
        return salleDto;
    }

    /**
     * Map salle entity to salle dto
     */
    private Salle SalleDtoToEntity(SalleDto salleDto){
        Salle salle = new Salle();
        salle.setId(salleDto.getId());
        salle.setNom(salleDto.getNom());
        salle.setCapacite(salleDto.getCapacite());

        return salle;
    }
}
