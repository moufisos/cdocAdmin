/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.fso.cdoc.admin.controllers;

import com.sos.fso.cdoc.admin.entities.Sujet;
import com.sos.fso.cdoc.admin.services.SujetFacade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author mohammedoufi
 */
@Named(value = "sujetController")
@Dependent
public class sujetController implements Serializable{
    private Sujet current = new Sujet();
    private List<Sujet> Sujet;
    
    @Inject
    private SujetFacade sujetService;
    

    /**
     * Creates a new instance of sujetController
     */
    public sujetController() {
    }

    public Sujet getCurrent() {
        return current;
    }

    public void setCurrent(Sujet current) {
        this.current = current;
    }
    
    public List<Sujet> getAll(){
        return sujetService.findAll();
    }
    
    //Show methods
    
    public String showCreate(Sujet sujet){
        current = sujet;
    return "List?faces-redirect=true";
    }
    
    public String showList() {
        return "list?faces-redirect=true";
    }
    
    //CRUD operations
    
    public String doCreate(Sujet sujet){
    sujetService.create(sujet);
       return showCreate(sujet);      
    }
    
}
