package com.example.chargebackcalcdemo.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.example.chargebackcalcdemo.models.LodgeComplaint;

public interface Lodgecomplaintdao extends CrudRepository<LodgeComplaint,Integer>
{
    public  LodgeComplaint findBycustomerid(long customerId); 
    @Query("select customerid from LodgeComplaint")
	public Set<Long> getAllCustomerIds();

}
