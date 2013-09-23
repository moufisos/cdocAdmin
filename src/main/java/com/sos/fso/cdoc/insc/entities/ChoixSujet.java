/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.fso.cdoc.insc.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mab.salhi
 */
@Entity
@Table(name = "t_choix_sujet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChoixSujet.findAll", query = "SELECT c FROM ChoixSujet c"),
    @NamedQuery(name = "ChoixSujet.findByIdChoix", query = "SELECT c FROM ChoixSujet c WHERE c.idChoix = :idChoix"),
    @NamedQuery(name = "ChoixSujet.findByOptimisticLock", query = "SELECT c FROM ChoixSujet c WHERE c.optimisticLock = :optimisticLock"),
    @NamedQuery(name = "ChoixSujet.findByEncadrant", query = "SELECT c FROM ChoixSujet c WHERE c.encadrant = :encadrant"),
    @NamedQuery(name = "ChoixSujet.findByLaboEquipe", query = "SELECT c FROM ChoixSujet c WHERE c.laboEquipe = :laboEquipe"),
    @NamedQuery(name = "ChoixSujet.findByEtablissement", query = "SELECT c FROM ChoixSujet c WHERE c.etablissement = :etablissement")})
public class ChoixSujet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_choix")
    private Integer idChoix;
    @Column(name = "optimistic_lock")
    private Integer optimisticLock;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 75)
    @Column(name = "encadrant")
    private String encadrant;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "labo_equipe")
    private String laboEquipe;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "etablissement")
    private String etablissement;
    @JoinColumn(name = "sujet", referencedColumnName = "id_sujet")
    @ManyToOne
    private Sujet sujet;
    @JoinColumn(name = "etudiant", referencedColumnName = "id_etudiant")
    @ManyToOne
    private Etudiant etudiant;

    public ChoixSujet() {
    }

    public ChoixSujet(Integer idChoix) {
        this.idChoix = idChoix;
    }

    public ChoixSujet(Integer idChoix, String encadrant, String laboEquipe, String etablissement) {
        this.idChoix = idChoix;
        this.encadrant = encadrant;
        this.laboEquipe = laboEquipe;
        this.etablissement = etablissement;
    }

    public Integer getIdChoix() {
        return idChoix;
    }

    public void setIdChoix(Integer idChoix) {
        this.idChoix = idChoix;
    }

    public Integer getOptimisticLock() {
        return optimisticLock;
    }

    public void setOptimisticLock(Integer optimisticLock) {
        this.optimisticLock = optimisticLock;
    }

    public String getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(String encadrant) {
        this.encadrant = encadrant;
    }

    public String getLaboEquipe() {
        return laboEquipe;
    }

    public void setLaboEquipe(String laboEquipe) {
        this.laboEquipe = laboEquipe;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public Sujet getSujet() {
        return sujet;
    }

    public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idChoix != null ? idChoix.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChoixSujet)) {
            return false;
        }
        ChoixSujet other = (ChoixSujet) object;
        if ((this.idChoix == null && other.idChoix != null) || (this.idChoix != null && !this.idChoix.equals(other.idChoix))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sos.fso.cdoc.insc.entities.ChoixSujet[ idChoix=" + idChoix + " ]";
    }
    
}
