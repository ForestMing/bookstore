package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Customer;
import com.example.bookstore.mapper.CustomerMapper;
import com.example.bookstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CustomerService")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper ;

    @Override
    public int isExistName(String cusname) {
        return customerMapper.selectExistCusName(cusname);
    }

    @Override
    public int insertCus(Customer customer) {
        return  customerMapper.insertCus(customer);
    }

    @Override
    public int checkCnameAndCpwd(Customer customer) {
        return customerMapper.checkCnameAndCpwd(customer);
    }
}
