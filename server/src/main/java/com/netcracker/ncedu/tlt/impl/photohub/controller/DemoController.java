package com.netcracker.ncedu.tlt.impl.photohub.controller;

import com.netcracker.ncedu.tlt.impl.photohub.model.User;
import com.netcracker.ncedu.tlt.impl.photohub.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/demo")
public class DemoController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUserPost(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}


