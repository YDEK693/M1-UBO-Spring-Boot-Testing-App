package com.dtos;

import com.entities.TSallesal;

import javax.persistence.*;
import java.util.Set;

public class GestionnaireDto {
    private static final long serialVersionUID = 1L;

    private Integer gstId;

    private String gstPers;

    private String gstAssocNom;

    private String gstAssocPres;
    private Set<TSallesal> tSallesalSet;
}
