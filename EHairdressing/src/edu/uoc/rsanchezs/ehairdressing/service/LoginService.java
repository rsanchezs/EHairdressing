package edu.uoc.rsanchezs.ehairdressing.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import edu.uoc.rsanchezs.ehairdressing.util.Loggable;

/**
 * Session Bean implementation class LoginService
 */
@Loggable
@Named
@Stateless
@LocalBean
public class LoginService {
	
	@Inject
	private Logger logger;

	private String username;
	private String password;
	
	
	public LoginService() {
		super();
	}

	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	public String login() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.login(this.username, this.password);
			logger.fine("User is logged");
		} catch (ServletException e) {
			
			logger.log(Level.SEVERE, "Loging failed", e);
			context.addMessage(null, new FacesMessage("Login failed."));
			return "/access-denied?faces-redirect=true";
		}
		return "/empty-page?faces-redirect=true";
	}
	

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		try {
			request.logout();
			logger.fine("Logout of the system");
		} catch (ServletException e) {
			logger.log(Level.SEVERE, "Logout failed", e);
			context.addMessage(null, new FacesMessage("Logout failed."));
			return null;
		}
		return "/index?faces-redirect=true";
	}

}
