package com.entities;


import javax.persistence.*;

import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
public class Soiree {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String nom;
    @OneToOne
    private Salle salle;
    private ArrayList<Concert> concerts;

}