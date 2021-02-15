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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((favouriteColour == null) ? 0 : favouriteColour.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (favouriteColour == null) {
			if (other.favouriteColour != null)
				return false;
		} else if (!favouriteColour.equals(other.favouriteColour))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", favouriteColour=" + favouriteColour + "]";
	}
	

}
