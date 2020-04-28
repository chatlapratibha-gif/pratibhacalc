package com.example.chargebackcalcdemo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.chargebackcalcdemo.models.Transactions;

public interface TransacDao extends CrudRepository<Transactions, Integer> 
{
	public List<Transactions> findAll();
	public Transactions findById(int id);

}
