package com.example.chargebackcalcdemo.models;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankinfo")
public class Bank
{
	
	@Id
	@Generated("assigned")
	private String bankacno;
	@Column
	private String branchname;
	@Column
	private String branchaddress;
	@Column
	private double avlbal;
	@Override
	public String toString() {
		return "Bank [bankacno=" + bankacno + ", branchname=" + branchname + ", branchaddress=" + branchaddress
				+ ", avlbal=" + avlbal + "]";
	}
	public String getBankacno() {
		return bankacno;
	}
	public void setBankacno(String bankacno) {
		this.bankacno = bankacno;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getBranchaddress() {
		return branchaddress;
	}
	public void setBranchaddress(String branchaddress) {
		this.branchaddress = branchaddress;
	}
	public double getAvlbal() {
		return avlbal;
	}
	public void setAvlbal(double avlbal) {
		this.avlbal = avlbal;
	}
		
	
}
