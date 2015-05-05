package edu.uoc.rsanchezs.ehairdressing.model;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Schedule
 *
 */
@MappedSuperclass
public class Schedule implements Serializable {

	
	private Long id;
	private String description;
	private static final long serialVersionUID = 1L;

	public Schedule() {
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
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
