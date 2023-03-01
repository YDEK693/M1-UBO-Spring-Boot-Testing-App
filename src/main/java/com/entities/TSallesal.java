/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.entities;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author yoann.dekergario
 */
@Entity
@Table(name = "t_Salle_sal")
@NamedQueries({
    @NamedQuery(name = "TSallesal.findAll", query = "SELECT t FROM TSallesal t"),
    @NamedQuery(name = "TSallesal.findBySalId", query = "SELECT t FROM TSallesal t WHERE t.salId = :salId"),
    @NamedQuery(name = "TSallesal.findBySalCapacite", query = "SELECT t FROM TSallesal t WHERE t.salCapacite = :salCapacite"),
    @NamedQuery(name = "TSallesal.findAgendaSalle", query = "SELECT t FROM TSallesal t "
    		+ "JOIN t.tSoireesorSet s "
    		+ "join s.tConcertconSet c "
    		+ "WHERE t.salId = :salId")})
@Data
public class TSallesal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sal_id")
    private long salId;
    @Column(name = "sal_capacite")
    private Integer salCapacite;
    @Column(name = "sal_nom")
    private String salNom;
    @Column(name = "sal_adresse")
    private String salAdresse;
    @JoinColumn(name = "t_gestionnaire_gst_gst_id", referencedColumnName = "gst_id")
    @ManyToOne(optional = false)
    private TGestionnaireGst tGestionnaireGstGstId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sallId")
    private Set<TSoireesor> tSoireesorSet;

    public TSallesal() {
    }

    public TSallesal(Integer salId) {
        this.salId = salId;
    }

    public long getSalId() {
        return salId;
    }

    public void setSalId(long salId) {
        this.salId = salId;
    }

    public Integer getSalCapacite() {
        return salCapacite;
    }

    public void setSalCapacite(Integer salCapacité) {
        this.salCapacite = salCapacité;
    }

    public String getSalNom() {
        return salNom;
    }

    public void setSalNom(String salNom) {
        this.salNom = salNom;
    }

    public String getSalAdresse() {
        return salAdresse;
    }

    public void setSalAdresse(String salAdresse) {
        this.salAdresse = salAdresse;
    }

    public TGestionnaireGst gettGestionnaireGstGstId() {
        return tGestionnaireGstGstId;
    }

    public void settGestionnaireGstGstId(TGestionnaireGst tGestionnaireGstGstId) {
        this.tGestionnaireGstGstId = tGestionnaireGstGstId;
    }

    public Set<TSoireesor> gettSoireesorSet() {
        return tSoireesorSet;
    }

    public void settSoireesorSet(Set<TSoireesor> tSoireesorSet) {
        this.tSoireesorSet = tSoireesorSet;
    }




    @Override
    public String toString() {
        return "donnees.TSallesal[ salId=" + salId + " ]";
    }
    
}
