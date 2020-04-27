package com.example.chargebackcalcdemo.services;

import java.util.List;

import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.AdminLogin;
import com.example.chargebackcalcdemo.models.Employee;

public interface AdminServices {
	public int CreateAd(Admin admin);
	public int login(AdminLogin adminlogin);
	public List<Employee> listemp();
	public boolean activate(String cusId);
	public boolean deactivate(String cusId);
	

}
