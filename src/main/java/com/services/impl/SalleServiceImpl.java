package com.services.impl;



import com.dtos.SalleDto;
import com.entities.Concert;
import com.entities.Salle;
import com.entities.TSallesal;
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
        List<TSallesal> salles = salleRepository.findAll();
        salles.forEach(salle -> {
            salleDtos.add(salleEntityToDto(salle));
        });
        return salleDtos;
    }

    @Override
    public SalleDto saveSalle(SalleDto salleDto) {
        // Converts the dto to the dog entity
        TSallesal salle = SalleDtoToEntity(salleDto);
        // Save the dog entity
        salle = salleRepository.save(salle);
        // Return the new dto
        return salleEntityToDto(salle);
    }

    @Override
    public SalleDto getSalleById(Long salleId) {
        TSallesal salle = salleRepository.findById(salleId).orElseThrow(() -> new EntityNotFoundException("salle not found"));
        return salleEntityToDto(salle);
    }

    @Override
    public boolean deleteSalle(Long salleId) {
        salleRepository.deleteById(salleId);
        return true;
    }

    /**
     * Map salle dto to salle entity
     */
    private SalleDto salleEntityToDto(TSallesal salle){
        SalleDto salleDto = new SalleDto();
        salleDto.setId(salle.getSalId());
        salleDto.setNom(salle.getSalNom());
        salleDto.setCapacite(salle.getSalCapacite());
        salleDto.setAdresse(salle.getSalAdresse());
        salleDto.setGestionnaireId(salle.gettGestionnaireGstGstId());


        return salleDto;
    }

    /**
     * Map salle entity to salle dto
     */
    private TSallesal SalleDtoToEntity(SalleDto salleDto){
        TSallesal salle = new TSallesal();
        salle.setSalId(salleDto.getId());
        salle.setSalNom(salleDto.getNom());
        salle.setSalCapacite(salleDto.getCapacite());
        salle.setSalAdresse(salleDto.getAdresse());
        salle.settGestionnaireGstGstId(salleDto.getGestionnaireId());


        return salle;
    }
}
