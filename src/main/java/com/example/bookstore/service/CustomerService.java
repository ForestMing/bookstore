package com.example.bookstore.service;

import com.example.bookstore.entity.Customer;

public interface CustomerService {
    int isExistName(String cusname);
    int insertCus(Customer customer);
    int checkCnameAndCpwd(Customer customer);
}
