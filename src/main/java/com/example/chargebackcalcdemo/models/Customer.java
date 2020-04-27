package com.example.chargebackcalcdemo.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	@Id
	@SequenceGenerator(name = "custSequence", initialValue = 10001, allocationSize = 1, sequenceName = "CUSTOMER_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custSequence")
	private long customerId;
	@Column(unique = true)
	private String cusId;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
	private String dob;
	@Column
	private String gender;
	@Column
	private String contactNumber;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String zipcode;
	@Column
	private String password;
	 @Column
	  private String status="no";
     
	
	  @OneToMany(targetEntity=Transactions.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="customer_id", referencedColumnName ="customerid" )
	 	
	
	 private List<Transactions> transacList;

	  @OneToMany(targetEntity=Bank.class ,cascade = CascadeType.ALL)
	  
	  @JoinColumn(name="customer_id", referencedColumnName ="customerid" )
	 	
	
	 private List<Bank> bankinfoo; 
	
	
	     
	

	public List<Bank> getBankinfoo() {
		return bankinfoo;
	}

	public void setBankinfoo(List<Bank> bankinfoo) {
		this.bankinfoo = bankinfoo;
	}

	public List<Transactions> getTransacList() {
		return transacList;
	}

	public void setTransacList(List<Transactions> transacList) {
		this.transacList = transacList;
	}
	

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", cusId=" + cusId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", dob=" + dob + ", gender=" + gender + ", contactNumber=" + contactNumber + ", address="
				+ address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", password=" + password
				+ ", status=" + status + ", transacList=" + transacList + ", bankdetails=" + bankinfoo + "]";
	}
	
	
}
