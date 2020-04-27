package com.example.chargebackcalcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.AdminDao;
import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.models.Admin;
import com.example.chargebackcalcdemo.models.AdminLogin;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.Employee;

@Service
@Component
public class AdminServicesImpl implements AdminServices {
	@Autowired
	private AdminDao dao;
	@Autowired
	private CusDao cdao;
	@Override
	public int CreateAd(Admin admin) {
		Admin a=dao.findByadminId(admin.getAdminId());
		if(a==null) {
			Admin a1=dao.save(admin);
			if (a1 != null) {
				return 1;
			} else 
			{
				return 2;
			}
		}
		return 0;
	}

	@Override
	public int login(AdminLogin adminlogin) {
		Admin a =dao.findByadminId(adminlogin.getAdminId());
		 if(a==null)
		 {
		   return 1;
		 }
		 else
		 {
		 return 2;
		 }
}
	
	 
	@Override
	public boolean activate(String cusId) {
		// TODO Auto-generated method stub
		Customer c=cdao.findBycusId(cusId);
		String s=c.getStatus();
		c.setStatus("yes");
		Customer c1=cdao.save(c);
		if(c1.getStatus().equals(s))
		{
		return false;
	}
		return true;
		}

	@Override
	public boolean deactivate(String cusId) {
		Customer c=cdao.findBycusId(cusId);
		String s=c.getStatus();
		c.setStatus("no");
		Customer c1=cdao.save(c);
		if(c1.getStatus().equals(s)) {
		return false;
	}
		return true;
	}
	 
	


	@Override
	public List<Employee> listemp() {
		// TODO Auto-generated method stub
		return null;
	}

			}
