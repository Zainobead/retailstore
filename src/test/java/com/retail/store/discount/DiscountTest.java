package com.retail.store.discount;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import com.retail.store.discount.business.BillBusiness;
import com.retail.store.discount.model.Bill;
import com.retail.store.discount.model.User;

public class DiscountTest {

	@Test
	public void testCalculateUserDiscountAmount() 
	{
		BillBusiness billBusiness = new BillBusiness();
		User user = new User();
		user.setId(1L);
		user.setEmployee(true);
		user.setUserName("Zain");
		Bill bill = new Bill();
		bill.setId(1L);
		bill.setBillAmount(1000.0);
		bill.setUser(user);
		BigDecimal amount = billBusiness.calculateBillDiscountAmount(bill, user);
		assertEquals(665, amount.intValue(), 0);
	}

	@Test
	public void testCalculateUserDiscountAmount_2() 
	{
		BillBusiness billBusiness = new BillBusiness();
		User user = new User();
		user.setId(2L);
		user.setEmployee(false);
		user.setUserName("Omar");
		Bill bill = new Bill();
		bill.setId(2L);
		bill.setBillAmount(2640.0);
		bill.setUser(user);
		BigDecimal amount = billBusiness.calculateBillDiscountAmount(bill, user);
		assertEquals(2257, amount.intValue(), 0);
	}

	@Test
	public void testCalculateBillsDiscount_3() 
	{
		BillBusiness billBusiness = new BillBusiness();
		User user = new User();
		user.setId(3L);
		user.setEmployee(true);
		user.setUserName("Saleh");
		Bill bill = new Bill();
		bill.setId(3L);
		bill.setBillAmount(740.0);
		bill.setUser(user);
		BigDecimal amount = billBusiness.calculateBillDiscountAmount(bill, user);
		assertEquals(492, amount.intValue(), 0);
	}
}
