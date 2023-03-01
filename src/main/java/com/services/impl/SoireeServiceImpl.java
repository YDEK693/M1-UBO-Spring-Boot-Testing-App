package com.services.impl;




import com.dtos.SoireeDto;

import com.entities.Soiree;
import com.repositories.SalleRepository;
import com.repositories.SoireeRepository;
import com.services.SoireeService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("SoireeService")
public class SoireeServiceImpl implements SoireeService {
    private final SoireeRepository soireeRepository;
    private final SalleRepository salleRepository;

    public SoireeServiceImpl(SoireeRepository soireeRepository,SalleRepository salleRepository){
        this.soireeRepository = soireeRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public List<SoireeDto> getAllSoirees() {
        List<SoireeDto> soireeDtos = new ArrayList<>();
        List<Soiree> soirees = soireeRepository.findAll();
        soirees.forEach(soiree -> {
            soireeDtos.add(soireeEntityToDto(soiree));
        });
        return soireeDtos;
    }

    @Override
    public SoireeDto saveSoiree(SoireeDto soireeDto) {
        // Converts the dto to the Soiree entity
        Soiree soiree = soireeDtoToEntity(soireeDto);
        // Save the Soiree entity
        soiree = soireeRepository.save(soiree);
        // Return the new dto
        return soireeEntityToDto(soiree);
    }

    @Override
    public SoireeDto getSoireeById(Long soireeId) {
        Soiree soiree = soireeRepository.findById(soireeId).orElseThrow(() -> new EntityNotFoundException("salle not found"));
        return soireeEntityToDto(soiree);
    }

    @Override
    public boolean deleteSoiree(Long soireeId) {
        soireeRepository.deleteById(soireeId);
        return true;
    }

    /**
     * Map Soiree dto to Soiree entity
     */
    private SoireeDto soireeEntityToDto(Soiree soiree){
        SoireeDto soireeDto = new SoireeDto();
      //  soireeDto.setId(soiree.getId());
        soireeDto.setNom(soiree.getNom());
        soireeDto.setSalleId(soiree.getSalle().getId());
        //ajouter boucle concert
        return soireeDto;
    }

    /**
     * Map soireeDto entity to soireeDto dto
     */
    private Soiree soireeDtoToEntity(SoireeDto soireeDto){
        Soiree soiree = new Soiree();
       // soiree.setId(soireeDto.getId());
        soiree.setNom(soireeDto.getNom());
       // soiree.setSalle(salleRepository.getById(soireeDto.getSalleId()));
        //ajouter boucle concert
        return soiree;
    }
}
