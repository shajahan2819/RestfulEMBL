package com.embl.RestfulEmbl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table (name="person")
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty( notes = "ID of the Person", name = "id", required = true,  value = "1")
	private long id;
	
	@Column (name="first_name")
	@ApiModelProperty( notes = "First Name of the Person", name = "firstName", required = true,  value = "Rosie")
	private String firstName;
	
	@Column (name="last_name")
	@ApiModelProperty( notes = "Last Name of the Person", name = "lastName", required = true,  value = "Binns")
	private String lastName;
	
	@Column (name="age")
	@ApiModelProperty( notes = "Age of the Person", name = "age", required = true,  value = "1")
	private int age;
	
	@Column (name="favourite_colour")
	@ApiModelProperty( notes = "Favourite colour of the Person", name = "favouriteColour", required = true,  value = "Red")
	private String favouriteColour;
	
		
	public Person() {
		super();
	}
	
	public Person(long id, String firstName, String lastName, String favouriteColour,int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.favouriteColour = favouriteColour;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFavouriteColour() {
		return favouriteColour;
	}
	public void setFavouriteColour(String favouriteColour) {
		this.favouriteColour = favouriteColour;
	}
	

}
