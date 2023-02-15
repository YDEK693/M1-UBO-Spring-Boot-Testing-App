package com.entities;

import java.util.*;
import javax.persistence.*;;
import lombok.Data;

@Entity
@Data
public class Concert {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    private Salle salle;
   // @OneToMany
    //private List<Integer> IDartistes;
    private Date date_debut;
    private Date date_fin;
    private double prix;
}