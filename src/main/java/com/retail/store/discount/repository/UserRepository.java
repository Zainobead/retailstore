package com.retail.store.discount.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.retail.store.discount.model.User;
@Repository

public interface UserRepository extends PagingAndSortingRepository<User, Long>  
{

}
