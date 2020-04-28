package com.example.chargebackcalcdemo.models;

import java.util.Date;

import java.util.List;
import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Transactionsofcust")
public class Transactions 
{
@Id
@Generated("assigned")
private int id;
@Column
private Date dateoftrans;
@Column
private double amount;
@Column
private long customer_id;


	 
	
public long getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(long customer_id) {
	this.customer_id = customer_id;
}
public int getId() 
{
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDateoftrans() {
	return dateoftrans;
}
public void setDateoftrans(Date dateoftrans) {
	this.dateoftrans = dateoftrans;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Transactions [id=" + id + ", dateoftrans=" + dateoftrans + ", amount=" + amount + "]";
}

}
