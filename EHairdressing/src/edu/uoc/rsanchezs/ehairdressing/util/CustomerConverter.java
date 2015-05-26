package edu.uoc.rsanchezs.ehairdressing.util;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import edu.uoc.rsanchezs.ehairdressing.model.Customer;
import edu.uoc.rsanchezs.ehairdressing.service.CustomerService;

@FacesConverter(forClass = edu.uoc.rsanchezs.ehairdressing.model.Customer.class, value="customer")
public class CustomerConverter implements Converter {
	
	@Inject
	private CustomerService customerService;
	

	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		
		if (value == null || value.isEmpty()) {
			return null;
		}
		try {
			String[] splited = value.split(" ");
			Object obj = customerService.findById(Long.valueOf(splited[0]));
				return obj;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(
					new FacesMessage(String.format("Tiene que seleccionar un cliente")), e);
		}
	
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent component, Object value) {
		
		if (!(value instanceof Customer)) {
			return null;
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append(String.valueOf(((Customer) value).getId())).
			append(" ").append(String.valueOf(((Customer) value).getName())).
			append(" ").append(String.valueOf(((Customer) value).getSurname()));
		
			return builder.toString();
		}
		
	}

}
