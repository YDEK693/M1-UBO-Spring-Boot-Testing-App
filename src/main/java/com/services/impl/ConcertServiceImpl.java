package com.services.impl;



import com.dtos.ConcertDto;
import com.entities.Concert;
import com.repositories.ConcertRepository;
import com.repositories.SalleRepository;
import com.services.ConcertService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("ConcertService")
public class ConcertServiceImpl implements ConcertService {
    private final ConcertRepository concertRepository;
    private final SalleRepository salleRepository;

    public ConcertServiceImpl(ConcertRepository concertRepository, SalleRepository salleRepository){
        this.concertRepository = concertRepository;
        this.salleRepository = salleRepository;
    }

    @Override
    public List<ConcertDto> getAllConcerts() {
        List<ConcertDto> concertDtos = new ArrayList<>();
        List<Concert> concerts = concertRepository.findAll();
        concerts.forEach(concert -> {
            concertDtos.add(concertEntityToDto(concert));
        });
        return concertDtos;
    }

    @Override
    public ConcertDto saveConcert(ConcertDto ConcertDto) {
       // Converts the dto to the concert entity
        Concert Concert = ConcertDtoToEntity(ConcertDto);
        // Save the concert entity
        Concert = concertRepository.save(Concert);
        // Return the new dto
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
    private ConcertDto concertEntityToDto(Concert concert){
        ConcertDto concertDto = new ConcertDto();
        concertDto.setId(concert.getId());
        concertDto.setDate_debut(concert.getDate_debut());
        concertDto.setDate_fin(concert.getDate_fin());
        concertDto.setPrix(concert.getPrix());
       /*
        concertDto.setParicipant(new ArrayList<Integer>());
        for (Integer participant: concert.getParticipant()) {
            concertDto.getParicipant().add(participant);
        }*/

        return concertDto;
    }

    /**
     * Map Concert entity to Concert dto
     */
    private Concert ConcertDtoToEntity(ConcertDto concertDto){
        Concert concert = new Concert();
        concert.setId(concertDto.getId());
        concert.setDate_debut(concertDto.getDate_debut());
        concert.setDate_fin(concertDto.getDate_fin());
        concert.setPrix(concertDto.getPrix());
        /*ajouter boucle pour liste participant
        concert.setParticipant(new ArrayList<Integer>());
        for (Integer groupeId: concertDto.getParicipant()) {
            concert.getParticipant().add(groupeId);
        }*/
        return concert;
    }
}
