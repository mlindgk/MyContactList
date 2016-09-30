package com.contactlist.data;

public class EmailAddress {
	private String workEmail;
	private String personalEmail;
	
	
	public EmailAddress(String workEmail, String personalEmail) {
		this.workEmail = workEmail;
		this.personalEmail = personalEmail;
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
	
	
}
