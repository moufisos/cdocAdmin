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
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author mohammedoufi
 */
@Named(value = "sujetController")
@SessionScoped
public class SujetController1 implements Serializable{
    private Sujet current = new Sujet();
    private Sujet newSujet;
    private List<Sujet> Sujet;
    
    @Inject
    private SujetFacade sujetService;
    

    /**
     * Creates a new instance of SujetController
     */
    public SujetController1() {
    }

    public Sujet getCurrent() {
        return current;
    }

    public void setCurrent(Sujet current) {
        this.current = current;
    }

    public Sujet getNewSujet() {
        return newSujet;
    }

    public void setNewSujet(Sujet newSujet) {
        this.newSujet = newSujet;
    }
    
    
    
    public List<Sujet> getAll(){
        return sujetService.findAll();
    }
    
    //Show methods
    
    public String showCreate(){
        this.newSujet = new Sujet();
    return "add?faces-redirect=true";
    }
    
    public String showList() {
        return "list?faces-redirect=true";
    }
    public String showEdit(Sujet sujet){
    current=sujet;
    return "edit?faces-redirect=true";
    }
    
    
    //CRUD operations
    
    public String doCreate(){
    sujetService.create(newSujet);
       return showList();      
    }
    
    public String doUpdate(){
        sujetService.edit(current);
    return showList();
    }
    
    
    
    
    public Sujet getSujet(java.lang.Integer id) {
        return sujetService.find(id);
    }
    @FacesConverter(forClass = Sujet.class)
    public static class SujetControllerConverter implements javax.faces.convert.Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            SujetController1 controller = (SujetController1) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "sujetController");
            return controller.getSujet(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Sujet) {
                Sujet o = (Sujet) object;
                return getStringKey(o.getIdSujet());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Sujet.class.getName());
            }
        }
    
}
}
