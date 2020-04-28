package com.example.chargebackcalcdemo.models;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lodgecomplaint")

public class LodgeComplaint {

		
	@Generated(value = "assigned")
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String contactnumber;
	@Column
	private String emailid;
	@Id 
	@Column
	private String bankaccountnumber;
	@Column
	private String bankname;
	@Column
	private String branchname;
	@Column
	private long customerid;
	@Column
	private String chargebackamount;
	@Column
	private Date date;
	@Column
	private String reason;
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getBankaccountnumber() {
		return bankaccountnumber;
	}
	public void setBankaccountnumber(String bankaccountnumber) {
		this.bankaccountnumber = bankaccountnumber;
	}
	public String getBankname() {
		return bankname;
	}
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getChargebackamount() {
		return chargebackamount;
	}
	public void setChargebackamount(String chargebackamount) {
		this.chargebackamount = chargebackamount;
	}
	public Date getDate() {
		return date;
	}
	
	public void setDate(String date) {
		
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
		this.date = dateformat.parse(date);
		}catch (Exception e) {

e.printStackTrace();
			}
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	@Override
	public String toString() {
		return "LodgeComplaint [firstname=" + firstname + ", lastname=" + lastname + ", contactnumber=" + contactnumber
				+ ", emailid=" + emailid + ", bankaccountnumber=" + bankaccountnumber + ", bankname=" + bankname
				+ ", branchname=" + branchname + ", customerid=" + customerid + ", chargebackamount=" + chargebackamount
				+ ", date=" + date + ", reason=" + reason + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
