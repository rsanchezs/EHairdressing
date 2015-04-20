package edu.uoc.rsanchezs.ehairdressing.model;

import edu.uoc.rsanchezs.ehairdressing.model.Address;
import edu.uoc.rsanchezs.ehairdressing.model.Gender;
import edu.uoc.rsanchezs.ehairdressing.model.User;
import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@DiscriminatorValue("C")
public class Customer extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String lastname;
	@Embedded
	private Address address;
	@Temporal(DATE)
	private Date dateOfBirth;
	@Enumerated(STRING)
	private Gender gender;
	

	public Customer() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}   
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}   
	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}   
	public Gender getGender() {
		return this.gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
   
}
