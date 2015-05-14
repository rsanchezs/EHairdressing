package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * Entity implementation class for Entity: Customer
 *
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
		@NamedQuery(name = "Customer.getBirthDay", query = "SELECT c.dateOfBirth FROM Customer c WHERE c.id = :id"),
		@NamedQuery(name = "Customer.countCustomerTotal", query ="SELECT COUNT(c) FROM Customer c") })
public class Customer extends User implements Serializable {

	public static final String FIND_ALL = "Customer.findAll";
	public static final String GET_BIRTHDAY = "Customer.getBirthDay";
	public static final String COUNT_TOTAL = "Customer.countCustomerTotal";
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String surname;
	private String mobilePhone;
	private Date dateOfBirth;
	private String birthday;
	private Integer age;
	private Gender gender;
	private Profile profile;
	private Date creationDate = new Date();
	private Address address = new Address();
	

	public Customer() {
		super();
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return the address
	 */
	@Embedded
	public Address getAddress() {
		return address;
	}

	/**
	 * @return the dateOfBirth
	 */
	@Temporal(TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the age
	 */
	@Transient
	public Integer getAge() {
		return age;
	}

	/**
	 * @return the creationDate
	 */
	@Temporal(TemporalType.DATE)
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @return the gender
	 */
	@Enumerated(EnumType.STRING)
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return the mobilePhone
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * @return the birthday
	 */
	
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * @param mobilePhone
	 *            the mobilePhone to set
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param surname
	 *            the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @param dateOfBirth
	 *            the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @param creationDate
	 *            the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	

	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	/**
	 * Method that calculate the age of a Customer
	 */
	@PostLoad
	@PostPersist
	@PostUpdate
	public void calculateAge() {
		if (dateOfBirth == null) {
			dateOfBirth = null;
			return;
		}

		Calendar birth = new GregorianCalendar();
		birth.setTime(new Date());
		Calendar now = new GregorianCalendar();
		now.setTime(new Date());
		int adjust = 0;

		if (now.get(Calendar.DAY_OF_YEAR) - birth.get(Calendar.DAY_OF_YEAR) < 0) {
			adjust = -1;
		}

		age = now.get(Calendar.YEAR) - birth.getMaximum(Calendar.YEAR) + adjust;
		
	}
	
//	/**	 
//	 * Method to return the day of the month that the customer was born
//	 * @return String representing the day of the month
//	 */
//	public @NotNull String getBirthDay() {
//
//		Calendar birthDay = new GregorianCalendar();
//		birthDay.setTime(dateOfBirth);
//		return Integer.toString( birthDay.get(Calendar.DAY_OF_MONTH));
//	}
//	
//	/**
//	 * Method to return the month that the customer was born
//	 *  * @return String representing the month
//	 */
//	public @NotNull String getBirthMonth() {
//		
//		Calendar birthMonth = new GregorianCalendar();
//		birthMonth.setTime(dateOfBirth);
//		return Integer.toString( birthMonth.get(Calendar.MONTH));
//	}
//	


}
