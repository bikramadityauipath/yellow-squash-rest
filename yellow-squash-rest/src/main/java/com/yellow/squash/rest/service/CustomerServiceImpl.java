package com.yellow.squash.rest.service;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value="customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

}