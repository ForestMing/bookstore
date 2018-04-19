package com.example.bookstore.mapper;

import com.example.bookstore.entity.Customer;

public interface CustomerMapper {
    int selectExistCusName(String cusname);
    int insertCus(Customer customer);
    int checkCnameAndCpwd(Customer customer);
    int selectCusId(String cName);

    Customer getCusInfoById(int cid);
}