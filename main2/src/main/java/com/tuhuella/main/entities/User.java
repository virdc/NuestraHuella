package com.tuhuella.main.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	String id;
	Photo photo;
	String name;
	String surname;
	String userName;
	String password;
	Integer age; 
	String street;
	Integer streetNumber;
	Zone zone;
	Integer phoneNumber;
	Integer alternativeNumber;
	String email;
	@Temporal(TemporalType.DATE)
	Date createUser;
	@Temporal(TemporalType.DATE)
	Date modifiedUser;
	Boolean active;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
	public Zone getZone() {
		return zone;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public Integer getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Integer getAlternativeNumber() {
		return alternativeNumber;
	}
	public void setAlternativeNumber(Integer alternativeNumber) {
		this.alternativeNumber = alternativeNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateUser() {
		return createUser;
	}
	public void setCreateUser(Date createUser) {
		this.createUser = createUser;
	}
	public Date getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(Date modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public User() {
		super();
	}
	
}
