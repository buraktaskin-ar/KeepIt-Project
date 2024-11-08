package app.entities;

import bg.constants.Gender;
import bg.constants.UserType;

public class User {

	private long id;
	
	@Override
	public String toString () {
		return "User{" +
			"id=" + id +
			", email='" + email + '\'' +
			", password='" + password + '\'' +
			", fName='" + fName + '\'' +
			", lName='" + lName + '\'' +
			", gender=" + gender +
			", userType='" + userType + '\'' +
			'}';
	}
	
	private String email;
	private String password;
	private String fName;
	private String lName;
	private Gender gender;
	private UserType userType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public User() {
	
	}

}
