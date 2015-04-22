package edu.uoc.rsanchezs.ehairdressing.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;


@Embeddable
@Access(AccessType.PROPERTY)
public class Address {
	
	private String street;
	private String city;
	private String province;
	private String zipcode;
	
	/**
	 * 
	 */
	public Address() {
		super();
	}
	/**
	 * @param street
	 * @param city
	 * @param province
	 * @param zipcode
	 */
	public Address(String street, String city, String province, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.province = province;
		this.zipcode = zipcode;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	

}
