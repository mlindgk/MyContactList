package com.contactlist.data;

public class ContactNo {
	private String workContactNo;
	private String personalContactNo;
	
	
	public ContactNo(String workContactNo, String personalContactNo) {
		this.workContactNo = workContactNo;
		this.personalContactNo = personalContactNo;
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
	
	
	
}
