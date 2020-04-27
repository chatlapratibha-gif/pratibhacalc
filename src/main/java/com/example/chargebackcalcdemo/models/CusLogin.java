package com.example.chargebackcalcdemo.models;

import javax.validation.constraints.NotEmpty;

public class CusLogin {
	@NotEmpty(message="This field should not be empty")
	private String cusId;
	@NotEmpty(message="This field should not be empty")
	private String password;
	public String getCusId() {
		return cusId;
	}
	public void setCusId(String cusId) {
		this.cusId = cusId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "CusLogin [cusId=" + cusId + ", password=" + password + "]";
	}
	

}
