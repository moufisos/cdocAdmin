/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.fso.cdoc.admin.controllers;

import com.sos.fso.cdoc.admin.entities.Activation;
import com.sos.fso.cdoc.admin.entities.Compte;
import com.sos.fso.cdoc.admin.entities.Etudiant;
import com.sos.fso.cdoc.admin.services.ActivationFacade;
import com.sos.fso.cdoc.admin.services.CompteFacade;
import com.sos.fso.cdoc.admin.services.EtudiantFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author mab.salhi
 */
@Named(value = "etudiantController")
@SessionScoped
public class EtudiantController implements Serializable {

    // ======================================
    // = Attributes =
    // ======================================
    @Inject
    private EtudiantFacade etudiantService;
    private Etudiant current;
    private List<Etudiant> Etudiants;
    
    @Inject
    private CompteFacade compteService;
    private Compte newCompte;
    @Inject
    private ActivationFacade activationservice;
    private Activation activation;
    
    
    
    // ======================================
    // = Navigation Methods =
    // ======================================
    public String showDetails(Etudiant etudiant) {
        return "/etudiant/view?faces-redirect=true";
    }


    
    public String showEdit(Etudiant item) {
        current = item;
        return "/etudiant/edit?faces-redirect=true";
    }

    public String showList() {
        return "/etudiant/list?faces-redirect=true";
    }
    // ======================================
    // = Business Methods =
    // ======================================
    public List<Etudiant> getAll(){
        return etudiantService.findAll();
    }

    public String doUpdate() {
        etudiantService.edit(current);
        return showList();
    }
    
    public String doRemove(Etudiant etudiant){
        etudiantService.remove(etudiant);
        return showList();
    }
    
    // ======================================
    // = Constructors =
    // ======================================
    public EtudiantController() {
    }

    // ======================================
    // = Getters & setters =
    // ======================================
    public Etudiant getCurrent() {
        return current;
    }

    public void setCurrent(Etudiant current) {
        this.current = current;
    }


    public Compte getNewCompte() {
        return newCompte;
    }

    public void setNewCompte(Compte newCompte) {
        this.newCompte = newCompte;
    }
    
}
