package com.services;

import com.dtos.SoireeDto;

import java.util.List;

public interface SoireeService {
    /**
     * Sauve a Soiree
     */
    SoireeDto saveSoiree(SoireeDto soireeDto);

    /**
     * Get a Soiree by it's id
     */
    SoireeDto getSoireeById(Long soireeId);

    /**
     * Delete a Soiree by it's id
     */
    boolean deleteSoiree(Long soireeId);

    /**
     * Get all the Soiree
     */
    List<SoireeDto> getAllSoirees();


}
