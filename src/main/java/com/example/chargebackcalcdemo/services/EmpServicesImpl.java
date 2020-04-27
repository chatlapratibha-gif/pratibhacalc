package com.example.chargebackcalcdemo.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.chargebackcalcdemo.dao.CusDao;
import com.example.chargebackcalcdemo.dao.EmpDao;
import com.example.chargebackcalcdemo.dao.TransacDao;
import com.example.chargebackcalcdemo.models.Customer;
import com.example.chargebackcalcdemo.models.EmpLogin;
import com.example.chargebackcalcdemo.models.Employee;
import com.example.chargebackcalcdemo.models.Transactions;
@Service
@Component
public class EmpServicesImpl implements EmpServices {
   @Autowired
   private EmpDao dao;
   @Autowired
   private CusDao cdao;
   @Autowired
   private TransacDao tdao;
   
	@Override
	public int CreateEmp(Employee emp) {
		Employee e=dao.findByempId(emp.getEmpId());
		if(e==null) {
			Employee e1=dao.save(emp);
			if (e1 != null) {
				return 1;
			} else {
				return 2;
			}
		}
		return 0;
		
	}

	@Override
	public int login(EmpLogin emplogin) {
		Employee e=dao.findByempId(emplogin.getEmpId());
		 if(e==null)
		 {
		   return 1;
		 }
		 else
		 {
		 return 2;
		 }

	}

	@Override
	public List<Customer> cusList() {
		return cdao.findAll();
	}

	/*
	 * @Override public List<Customer> serchBycustomerId(String customerId) { return
	 * cdao.searchcustomerId(customerId+"%"); }
	 */
	
}
