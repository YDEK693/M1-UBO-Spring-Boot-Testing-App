package com.dtos;



import lombok.Data;

import java.util.ArrayList;
@Data
public class SoireeDto {

    private int Id;
    private String nom;
    private long salleId;
    private ArrayList<Integer> concertID;

}
