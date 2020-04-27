package com.example.chargebackcalcdemo.models;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bankdetails")
public class BankDetails
{
	@Id
	@Generated("assigned")
private String BankAcNo;
	@Column
private String BankBranchName;
	@Column
private String BankAddress;
	@Column
private double AvailableBal;
	
public String getBankAcNo() {
	return BankAcNo;
}
public void setBankAcNo(String bankAcNo) {
	BankAcNo = bankAcNo;
}
public String getBankBranchName() {
	return BankBranchName;
}
public void setBankBranchName(String bankBranchName) {
	BankBranchName = bankBranchName;
}
public String getBankAddress() {
	return BankAddress;
}
public void setBankAddress(String bankAddress) {
	BankAddress = bankAddress;
}
public double getAvailableBal() {
	return AvailableBal;
}
public void setAvailableBal(double availableBal) {
	AvailableBal = availableBal;
}
@Override
public String toString() {
	return "BankDetails [BankAcNo=" + BankAcNo + ", BankBranchName=" + BankBranchName + ", BankAddress=" + BankAddress
			+ ", AvailableBal=" + AvailableBal + "]";
}


}
