package edu.uoc.rsanchezs.ehairdressing.model;

import static javax.persistence.CascadeType.ALL;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Past;

import edu.uoc.rsanchezs.ehairdressing.constraints.NotEmpty;
import edu.uoc.rsanchezs.ehairdressing.util.PersistGroup;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;

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
	private List<Appointment> appointments = new ArrayList<Appointment>();
	

	public Customer() {
		super();
	}
	

	/**
	 * @param name
	 * @param surname
	 * @param mobilePhone
	 * @param dateOfBirth
	 * @param birthday
	 * @param age
	 * @param gender
	 * @param profile
	 * @param creationDate
	 * @param address
	 */
	public Customer(String name, String surname, String mobilePhone,
			Date dateOfBirth, String birthday, Integer age, Gender gender,
			Profile profile, Date creationDate, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.mobilePhone = mobilePhone;
		this.dateOfBirth = dateOfBirth;
		this.birthday = birthday;
		this.age = age;
		this.gender = gender;
		this.profile = profile;
		this.creationDate = creationDate;
		this.address = address;
	}
	
	

	/**
	 * @param name
	 * @param surname
	 * @param mobilePhone
	 * @param dateOfBirth
	 * @param birthday
	 * @param age
	 * @param gender
	 * @param profile
	 * @param creationDate
	 * @param address
	 * @param appointments
	 */
	public Customer(String name, String surname, String mobilePhone,
			Date dateOfBirth, String birthday, Integer age, Gender gender,
			Profile profile, Date creationDate, Address address,
			List<Appointment> appointments) {
		super();
		this.name = name;
		this.surname = surname;
		this.mobilePhone = mobilePhone;
		this.dateOfBirth = dateOfBirth;
		this.birthday = birthday;
		this.age = age;
		this.gender = gender;
		this.profile = profile;
		this.creationDate = creationDate;
		this.address = address;
		this.appointments = appointments;
	}



	/**
	 * @return the name
	 */
	@NotEmpty(groups=PersistGroup.class)
	public String getName() {
		return name;
	}
	
	/**
	 * @return the surname
	 */
	@NotEmpty(groups=PersistGroup.class)
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
	@Past(groups=PersistGroup.class)
	@NotEmpty(groups=PersistGroup.class)
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
	@NotEmpty(groups=PersistGroup.class)
	public Gender getGender() {
		return gender;
	}

	/**
	 * @return the mobilePhone
	 */
	@NotEmpty(groups=PersistGroup.class)
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
	 * @return the appointments
	 */
	@OneToMany(mappedBy = "customer")
	public List<Appointment> getAppointments() {
		return appointments;
	}

	/**
	 * @param appointments the appointments to set
	 */
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	/**
	 * Method to add an Appointment in the list of
	 * appointments of this Customer
	 */
	public void add(Appointment appointment) {
		appointments.add(appointment);
		
	}
	
	/**
	 * Method to remove an Appointment in the list of
	 * appointments of this Customer
	 * @param appointment
	 */
	public void remove(Appointment appointment){
		appointments.remove(appointment);
		
	}

	/**
	 * Method that calculate the age of a Customer
	 */
	@PostLoad
	@PostPersist
	@PostUpdate
	public Integer calculateAge() {

		if (dateOfBirth == null) {
			return null;
		}else {
			Instant instant = Instant.ofEpochMilli(this.dateOfBirth.getTime());
			LocalDate birthday = LocalDateTime.ofInstant(instant,
					ZoneId.systemDefault()).toLocalDate();
			return this.age = (int) birthday.until(LocalDate.now(), ChronoUnit.YEARS);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(surname).append(" ").append(name);
		return builder.toString();
	}
	
	/**	 
	 * Method to return the day of the month that the customer was born
	 * @return String representing the day of the month
	 */
	public String getBirthDay() {

		if (dateOfBirth == null) {
			return null;
		} else {
			Calendar birthDay = new GregorianCalendar();
			birthDay.setTime(dateOfBirth);
			return Integer.toString(birthDay.get(Calendar.DAY_OF_MONTH));
		}
	}
	
	/**
	 * Method to return the month that the customer was born
	 *  * @return String representing the month
	 */
	public String getBirthMonth() {
		
		if (dateOfBirth == null) {
			return null;
		} else {
			Calendar birthMonth = new GregorianCalendar();
			birthMonth.setTime(dateOfBirth);
			return Integer.toString(birthMonth.get(Calendar.MONTH));
		}
	}
	
	public String calculateBirthDay() {
		return this.birthday = getBirthday() + "-" + getBirthMonth();
	}
	
}
