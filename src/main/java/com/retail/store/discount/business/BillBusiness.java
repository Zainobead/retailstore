package com.retail.store.discount.business;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.store.discount.exception.BusinessException;
import com.retail.store.discount.model.Bill;
import com.retail.store.discount.model.User;
import com.retail.store.discount.repository.BillRepository;

@Service
public class BillBusiness  {

	private static final String BILL_NOT_FOUND = "No Bill found for This Id";
	public static final double EMPLOYEE_DISCOUNT_VALUE = 0.30;
	public static final double CUSTOMER_DISCOUNT_VALUE = 0.10;
	public static final int BILL_DISCOUNT_LIMIT = 100;
	public static final int BILL_DISCOUNT_VALUE = 5;
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private UserBusiness userBusiness;
	
	public Bill findBillById(Long billId) throws BusinessException {
		return Optional.ofNullable(billRepository.findById(billId))
				.orElseThrow(()-> new BusinessException(BILL_NOT_FOUND)).get();
	}

	public Bill saveBill(Bill bill) throws BusinessException {
		User user = userBusiness.findById(bill.getUser().getId());
		BigDecimal billAmountAfterDiscount = calculateBillDiscountAmount(bill, user);
		bill.setBillAmountAfterDiscount(billAmountAfterDiscount);
		billRepository.save(bill);
		return bill;
	}

	public BigDecimal calculateBillDiscountAmount(Bill bill, User user) {

		boolean isEmployee = user.isEmployee();
        double discountPercent = calculateUserDiscountAmount(isEmployee);
		double billAmountAfterUserDiscount = calulcateBillAmountAfterUserDiscount(bill, discountPercent);
		double billDiscountAmount = calculateBillDiscount(billAmountAfterUserDiscount);

		return new BigDecimal((billAmountAfterUserDiscount - billDiscountAmount));
	}

	private double calculateUserDiscountAmount(boolean isEmployee) 
	{
		double discountPercent=0.0;
		if (isEmployee) 
		{
			discountPercent = EMPLOYEE_DISCOUNT_VALUE;
		} 
		else 
		{
			discountPercent = CUSTOMER_DISCOUNT_VALUE;
		}
		return discountPercent;
	}

	private double calulcateBillAmountAfterUserDiscount(Bill bill, double discountPercent) 
	{
		return  Math.ceil(bill.getBillAmount() - (bill.getBillAmount() * discountPercent));
	}

	private double calculateBillDiscount(double billAmountAfterUserDiscount) 
	{
		double billDiscountAmount = 0.0;
		if (billAmountAfterUserDiscount > 100) 
		{
			double billDiscountValue = (billAmountAfterUserDiscount / (double) BILL_DISCOUNT_LIMIT);
			billDiscountAmount = billDiscountValue * BILL_DISCOUNT_VALUE;
		}
		return Math.ceil(billDiscountAmount);
	}
	
}
