package com.retail.store.discount.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.retail.store.discount.model.Bill;
@Repository

public interface BillRepository extends PagingAndSortingRepository<Bill, Long>  
{

}
