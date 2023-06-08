package com.gufran.shadi.model;

import java.util.Objects;

public class UserAccount {

	private int id;
	private String userName;
	private String password;
	private String email;
	private int age;
	private long phoneNumber;
	private String gender;
	private String city;
	private static  String country = "India";
	private Interest interest;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public static String getCountry() {
		return country;
	}
	public static void setCountry(String country) {
		UserAccount.country = country;
	}
	public Interest getInterest() {
		return interest;
	}
	public void setInterest(Interest interest) {
		this.interest = interest;
	}
	public UserAccount(int id, String userName, String password, String email, int age, long phoneNumber, String gender,
			String city, Interest interest) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.city = city;
		this.interest = interest;
	}
	public UserAccount() {
		super();
	}
	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", age=" + age + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", city=" + city
				+ ", interest=" + interest + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAccount other = (UserAccount) obj;
		return id == other.id;
	}
	
}
