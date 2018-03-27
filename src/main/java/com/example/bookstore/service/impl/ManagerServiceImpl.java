package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Manager;
import com.example.bookstore.mapper.CustomerMapper;
import com.example.bookstore.mapper.ManagerMapper;
import com.example.bookstore.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper ;

    @Override
    public int loginManager(Manager manager) {
        return managerMapper.loginManager(manager);
    }
}
