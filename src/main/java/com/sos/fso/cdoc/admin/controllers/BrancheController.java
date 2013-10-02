/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sos.fso.cdoc.admin.controllers;

import com.sos.fso.cdoc.admin.entities.Branche;
import com.sos.fso.cdoc.admin.services.BrancheFacade;
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
@Named(value = "brancheController")
@SessionScoped
public class BrancheController implements Serializable{

    /**
     * Creates a new instance of BrancheController
     */
    @Inject 
    private BrancheFacade brancheService;
    private Branche current = new Branche(); 
    private Branche newBranche;
    
    
    
    public BrancheController() {
    }

    public Branche getCurrent() {
        return current;
    }

    public void setCurrent(Branche current) {
        this.current = current;
    }

    public Branche getNewBranche() {
        return newBranche;
    }

    public void setNewBranche(Branche newBranche) {
        this.newBranche = newBranche;
    }
    
    //shows methods
    
    
    public String showCreate(){
        this.newBranche=new Branche();
        return "/branche/add.xhtml?faces-redirect=true";
         
    }
    
    public String showEdit(Branche branche){
        current = branche;
        return "/branche/edit?faces-redirect=true";
    }
    
    public String showList(){
        return "/branche/list?faces-redirect=true";
    }
    
    //services methods
    public List<Branche> getAll() {
        return brancheService.findAll();
    }
    
    public String doCreate(){
        brancheService.create(newBranche);
        return showList();
    }
    
    public String doUpdate(){
        brancheService.edit(current);
        return showList();
    }
    
    public String doRemove(Branche branche){
        brancheService.remove(branche);
        return showList();
    }
    
    
    // object converter
    
      public Branche getBranche(java.lang.Integer id) {
        return brancheService.find(id);
    }
    
   @FacesConverter(forClass = Branche.class)
    public static class BrancheControllerConverter implements javax.faces.convert.Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BrancheController controller = (BrancheController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "brancheController");
            return controller.getBranche(getKey(value));
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
            if (object instanceof Branche) {
                Branche o = (Branche) object;
                return getStringKey(o.getIdBranche());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Branche.class.getName());
            }
        }
    
}
}
