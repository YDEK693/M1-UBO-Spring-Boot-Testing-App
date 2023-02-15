package com.entities;

import java.util.*;
import javax.persistence.*;;
import lombok.Data;

@Entity
@Data

public class Concert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Date date_debut;
    private Date date_fin;
    private double prix;
    @OneToOne
    private Salle salle;
    private List<Integer> participant;

}