package com.retail.store.discount.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {

	private Long id;
	private String userName;
	private boolean employee;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() 
	{
		return id;
	}
	
	public void setId(Long id) 
	{
		this.id = id;
	}
	
	@Column(name = "username", length = 500, nullable = false)
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	@Column(name = "employee_flag")
	public boolean isEmployee() 
	{
		return employee;
	}
	
	public void setEmployee(boolean employee) 
	{
		this.employee = employee;
	}


}
