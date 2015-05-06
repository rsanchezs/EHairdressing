package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Tag
 *
 */
@Entity
@NamedNativeQuery(name = "Tag.findAllbyName", query = "SELECT t.name FROM Tag t")
public class Tag implements Serializable {

	public static final String FIND_TAGS = "Tag.findAllbyName";
	
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;

	public Tag() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = SEQUENCE)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
