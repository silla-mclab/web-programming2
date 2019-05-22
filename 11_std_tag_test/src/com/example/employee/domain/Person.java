package com.example.employee.domain;

import java.time.LocalDate;

public class Person {
	private String name;
	private String gender;
	private int birthYear;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return LocalDate.now().getYear() - birthYear;
	}
	
	public void setAge(int age) {
		this.birthYear = LocalDate.now().getYear() - age;
	}
	
}
