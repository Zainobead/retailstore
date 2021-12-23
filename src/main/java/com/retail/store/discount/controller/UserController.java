package com.retail.store.discount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retail.store.discount.business.UserBusiness;
import com.retail.store.discount.exception.BusinessException;
import com.retail.store.discount.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class UserController {

    @Autowired
    private UserBusiness userBusiness;
	@Operation(summary = "Get User By ID")
	@ApiResponse(responseCode = "200", description = "Found the User", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getUser(@PathVariable("user_id") Long userId)
			throws BusinessException {

		return ResponseEntity.ok(userBusiness.findById(userId));
	}
	@Operation(summary = "Save new user")
	@ApiResponse(responseCode = "200", description = "User Saved", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = User.class)) })
	@PostMapping("/users")
	public ResponseEntity<User> saveUser(@RequestBody User user) {

		return ResponseEntity.ok(userBusiness.saveUser(user));
	}
    
}
