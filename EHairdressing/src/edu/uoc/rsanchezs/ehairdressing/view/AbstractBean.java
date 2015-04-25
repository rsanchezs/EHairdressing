package edu.uoc.rsanchezs.ehairdressing.view;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class AbstractBean {
	
	
	protected void addInformationMessage(String key) {
        FacesContext context = FacesContext.getCurrentInstance();
        ResourceBundle bundle = context.getApplication().
        		getResourceBundle(context, "i18n");
        String message = bundle.getString(key);
        FacesContext.getCurrentInstance().addMessage(null, 
        		new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
    }

    protected void addWarningMessage(String key) {
    	 FacesContext context = FacesContext.getCurrentInstance();
         ResourceBundle bundle = context.getApplication().
         		getResourceBundle(context, "i18n");
         String message = bundle.getString(key);
         FacesContext.getCurrentInstance().addMessage(null, 
         		new FacesMessage(FacesMessage.SEVERITY_WARN, message, null));
    }

    protected void addErrorMessage(String key) {
    	 FacesContext context = FacesContext.getCurrentInstance();
         ResourceBundle bundle = context.getApplication().
         		getResourceBundle(context, "i18n");
         String message = bundle.getString(key);
         FacesContext.getCurrentInstance().addMessage(null, 
         		new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }
}
