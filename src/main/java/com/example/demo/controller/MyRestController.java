package com.example.demo.controller;


import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.*;

import java.util.*;

@RestController
@RequestMapping("/users")  // 通过这个配置，下面的映射都在/users下
public class MyRestController{
    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getNumber(), user);
        new UserServiceImpl().create(user.getName(), user.getAge());
        return "success";
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer number){
        return users.get(number);
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Integer number, @ModelAttribute User user){
        User u = users.get(number);
        u.setNumber(user.getNumber());
        u.setAge(user.getAge());
        u.setName(user.getName());
        return "success";
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer number){
        users.remove(number);
        return "success";
    }

}