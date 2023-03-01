package com.dtos;

import com.entities.TGestionnaireGst;
import lombok.Data;

@Data
public class SalleDto {

	private long Id;

	private Integer capacite;
	private String nom;
	private String adresse;
	private TGestionnaireGst gestionnaireId;

}
