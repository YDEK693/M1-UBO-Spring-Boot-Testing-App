package com.dtos;




import lombok.Data;
import java.util.Date;
import java.util.ArrayList;
@Data
public class ConcertDto {

    private Long Id;
    private Date date_debut;
    private Date date_fin;
    private double prix;
    private ArrayList<Integer> paricipant;

}
