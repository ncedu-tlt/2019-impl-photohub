package com.netcracker.ncedu.tlt.impl.photohub.controller;

import com.netcracker.ncedu.tlt.impl.photohub.model.LoginData;
import com.netcracker.ncedu.tlt.impl.photohub.model.User;
import com.netcracker.ncedu.tlt.impl.photohub.model.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path="/api")
public class DemoController {
    @Autowired
    private UserRepository userRepository;


    @PostMapping(path="/registration ")
    public @ResponseBody String addNewUserPost(@RequestBody User user) {
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @PostMapping(path = "/auth")
    public void login(@RequestBody LoginData loginData, HttpServletResponse response) throws IOException {
        if(userRepository.existsByEmailAndPassword(loginData.getEmail(), loginData.getPassword())) {
            response.sendError(404);
        }

    }


}
