package com.services;

import com.dtos.ConcertDto;

import java.util.List;

public interface ConcertService {
    /**
     * Sauve a Concert
     */
    ConcertDto saveConcert(ConcertDto concertDto);

    /**
     * Get a Concert by it's id
     */
    ConcertDto getConcertById(Long ConcertId);

    /**
     * Delete a Concert by it's id
     */
    boolean deleteConcert(Long concertId);

    /**
     * Get all the Concert
     */
    List<ConcertDto> getAllConcerts();


}
