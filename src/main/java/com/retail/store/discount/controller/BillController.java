package com.retail.store.discount.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.discount.business.BillBusiness;
import com.retail.store.discount.exception.BusinessException;
import com.retail.store.discount.model.Bill;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class BillController {

    @Autowired
    private BillBusiness billBusiness;

    @Operation(summary = "Get Bill by ID")
    @ApiResponse(responseCode = "200", description = "Found the Bill", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Bill.class)) })
	@GetMapping("/bills/{bill_id}")
	public ResponseEntity<Bill> getBill(@PathVariable("bill_id") Long billId)
			throws BusinessException {

		return ResponseEntity.ok(billBusiness.findBillById(billId));
	}
    
    @Operation(summary = "Save New Bill")
    @ApiResponse(responseCode = "200", description = "Bill Saved", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = Bill.class)) })
	@PostMapping("/bills")
	public ResponseEntity<Bill> saveUserAndGetDiscount(@RequestBody Bill bill) throws BusinessException {

		return ResponseEntity.ok(billBusiness.saveBill(bill));
	}
    
}
