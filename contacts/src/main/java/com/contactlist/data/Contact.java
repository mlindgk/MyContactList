package com.contactlist.data;

public class Contact {

	private long id;
	private String firstName;
	private String lastName;
	private String workEmail;
	private String personalEmail;
	private String workContactNo;
	private String personalContactNo;
	
	public Contact() {
		
	}
	
	public Contact(long id, String firstName, String lastName, String workEmail, String personalEmail,
			String workContactNo, String personalContactNo) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.workEmail = workEmail;
		this.personalEmail = personalEmail;
		this.workContactNo = workContactNo;
		this.personalContactNo = personalContactNo;
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

	public String getWorkEmail() {
		return workEmail;
	}

	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getWorkContactNo() {
		return workContactNo;
	}

	public void setWorkContactNo(String workContactNo) {
		this.workContactNo = workContactNo;
	}

	public String getPersonalContactNo() {
		return personalContactNo;
	}

	public void setPersonalContactNo(String personalContactNo) {
		this.personalContactNo = personalContactNo;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", workEmail=" + workEmail
				+ ", personalEmail=" + personalEmail + ", workContactNo=" + workContactNo + ", personalContactNo="
				+ personalContactNo + "]";
	}


	
}
