package com.example.chargebackcalcdemo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.chargebackcalcdemo.models.Employee;

public interface EmpDao extends CrudRepository<Employee,String>{
     public Employee findByempId(String empId);
}
