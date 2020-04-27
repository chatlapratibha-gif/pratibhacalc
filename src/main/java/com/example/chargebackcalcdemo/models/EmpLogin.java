package com.example.chargebackcalcdemo.models;

import javax.validation.constraints.NotEmpty;

public class EmpLogin {
	@NotEmpty(message="This field should not be empty")
	private String empId;
	@NotEmpty(message="This field should not be empty")
	private String password;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmpLogin [empId=" + empId + ", password=" + password + "]";
	}
	

}
