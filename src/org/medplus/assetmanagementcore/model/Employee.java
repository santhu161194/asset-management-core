package org.medplus.assetmanagementcore.model;

import java.util.Date;

import org.medplus.assetmanagementcore.utils.Gender;

public class Employee {
	
	private String employeeId;
	
	private String firstName;

	private String lastName;
	
	private String password;
	
	private Gender gender ;
	
	private long mobileNumber;

	private Date dateOfJoin;
	
	private Date dateOfBirth;
	
	private String address;
	
	private double salary;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String modifiedBy;
	
	private Date dateModified;
	
	private Date ModifiedDate;
	
	public Date getDateModified() {
		return dateModified;
	}
	
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
	
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getModifiedBy() {
		return modifiedBy;
	}
	
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public long getMobileNumber() {
		return mobileNumber;
	}
	
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public Date getDateOfJoin() {
		return dateOfJoin;
	}
	
	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", password=" + password
				+ ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", dateOfJoin="
				+ dateOfJoin + ", dateOfBirth=" + dateOfBirth + ", address="
				+ address + ", salary=" + salary + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", dateModified=" + dateModified + "]";
	}

}
