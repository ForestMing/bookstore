package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Person;
import com.example.bookstore.mapper.PersonMapper;
import com.example.bookstore.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PersonService")
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonMapper personMapper;

    @Override
    public int addPerson(Person person) {
        return personMapper.insert(person);
    }
}
