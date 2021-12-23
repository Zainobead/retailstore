package com.retail.store.discount.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill")
public class Bill 
{
	private Long id;
	private User user;
	private Double billAmount;
	private BigDecimal billAmountAfterDiscount;
	
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() 
	{
		return user;
	}

	public void setUser(User user) 
	{
		this.user = user;
	}
	
	@Column(name = "bill_amount", nullable = false)
	public Double getBillAmount() 
	{
		return billAmount;
	}

	public void setBillAmount(Double billAmount) 
	{
		this.billAmount = billAmount;
	}

	@Column(name = "bill_amount_after_discount", nullable = false)
	public BigDecimal getBillAmountAfterDiscount() 
	{
		return billAmountAfterDiscount;
	}

	public void setBillAmountAfterDiscount(BigDecimal billAmountAfterDiscount) 
	{
		this.billAmountAfterDiscount = billAmountAfterDiscount;
	}
	
	

}
