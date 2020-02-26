package com.netcracker.ncedu.tlt.impl.photohub.controller;
import com.netcracker.ncedu.tlt.impl.photohub.model.LoginData;
import com.netcracker.ncedu.tlt.impl.photohub.model.User;
import org.apache.coyote.Response;
import com.netcracker.ncedu.tlt.impl.photohub.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path="/api")



public class APIController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/auth")
    public void login(@RequestBody LoginData loginData, HttpServletResponse response) throws IOException {
        if(!userRepository.existsByEmailAndPassword(loginData.getEmail(), loginData.getPassword())) {
            response.sendError(404);
        }

    }




}
