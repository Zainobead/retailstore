package com.retail.store.discount.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.store.discount.exception.BusinessException;
import com.retail.store.discount.model.User;
import com.retail.store.discount.repository.UserRepository;

@Service
public class UserBusiness  {
	private static final String USER_NOT_FOUND = "User Not Found";

	@Autowired
	private UserRepository userRepository;
	
	public User findById(Long userId) throws BusinessException 
	{
		return Optional.ofNullable(userRepository.findById(userId))
				.orElseThrow(() -> new BusinessException(USER_NOT_FOUND)).get();
	}

	public User saveUser(User user) 
	{
		userRepository.save(user);
		return user;
	}
	
}
