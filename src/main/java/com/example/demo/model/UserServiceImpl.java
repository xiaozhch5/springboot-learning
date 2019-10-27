package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age){
        System.out.println(name + age);
        jdbcTemplate.update("insert into USER values(?,?)", name, age);
    }

    @Override
    public void deleteByName(String name){
        jdbcTemplate.update("DELETE FROM USER WHERE NAME=?", name);
    }

    @Override
    public Integer getAllUsers(){
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void deleteAllUsers(){
        jdbcTemplate.update("delete from USER");
    }
}
