package com.services.impl;



import com.dtos.ConcertDto;
import com.entities.Concert;
import com.entities.Dog;
import com.repositories.ConcertRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("ConcertService")
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRepository concertRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> ConcertDtos = new ArrayList<>();
      /*  List<Concert> Concerts = ConcertRepository.findAll();
        Concerts.forEach(dog -> {
            ConcertDtos.add(ConcertEntityToDto(dog));
        });
        */

        return ConcertDtos;

    }

    @Override
    public ConcertDto saveConcert(ConcertDto ConcertDto) {
       // Converts the dto to the concert entity
        Concert Concert = ConcertDtoToEntity(ConcertDto);
        /* Save the concert entity
        Concert = ConcertRepository.save(Concert);
        // Return the new dto
        */
        return concertEntityToDto(Concert);
    }

    @Override
    public ConcertDto getConcertById(Long concertId) {
        Concert concert = concertRepository.findById(concertId).orElseThrow(() -> new EntityNotFoundException("Concert not found"));
        return concertEntityToDto(concert);
    }

    @Override
    public boolean deleteConcert(Long concertId) {
        concertRepository.deleteById(concertId);
        return true;
    }

    /**
     * Map Concert dto to Concert entity
     */
    private ConcertDto concertEntityToDto(Concert Concert){
        ConcertDto ConcertDto = new ConcertDto();
       /* ConcertDto.setPrix(Concert.getPrix()rix());
        ConcertDto.setNom(Concert.getNom());
        ConcertDto.setCapacite(Concert.getCapacite());*/
        return ConcertDto;
    }

    /**
     * Map Concert entity to Concert dto
     */
    private Concert ConcertDtoToEntity(ConcertDto ConcertDto){
        Concert Concert = new Concert();
       /* Concert.setId(ConcertDto.getId);
        Concert.setSalle();
        Concert.setDate_debut(ConcertDto.getCapacite());
        Concert.setDate_debut(ConcertDto.getCapacite());
        Concert.setPrix(ConcertDto.getNom());*/
        return Concert;
    }
}
