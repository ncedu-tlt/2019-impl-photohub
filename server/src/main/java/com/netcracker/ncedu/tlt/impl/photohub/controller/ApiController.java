package com.netcracker.ncedu.tlt.impl.photohub.controller;
import com.netcracker.ncedu.tlt.impl.photohub.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/api/user")
public class ApiController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SubscribeRepository subscribeRepository;

    @PostMapping(path = "/auth")
    public void login(@RequestBody LoginData loginData, HttpServletResponse response) throws IOException {
        if(!userRepository.existsByEmailAndPassword(loginData.getEmail(), loginData.getPassword())) {
            response.sendError(404);
        }
    }
    @PostMapping(path = "/registration")
    public void addUser(@RequestBody User user, HttpServletResponse response) throws IOException {
        if(userRepository.existsByEmailAndPassword(user.getEmail(), user.getPassword())) {
            response.sendError(409, "Такой пользователь уже есть");
        }
        else userRepository.save(user);
    }


    @PostMapping(path = "/subscribe")
    @ResponseBody
    public void addSubscribe(@RequestBody SubscribeData subscribeData) throws IOException{
        String emailSubscriber=subscribeData.getEmailSubscriber();
        String subscribeTo=subscribeData.getSubscribeTo();
        Subscription sub = new Subscription();
        sub.setEmailSubscriber(emailSubscriber);
        sub.setSubscribeTo(subscribeTo);
        subscribeRepository.save(sub);
    }

    @GetMapping(path = "/get/subscribe")
    @ResponseBody
    public Object getSubscribe(@RequestParam String email) throws IOException {
        List<String> subs = subscribeRepository.findByEmailSubscriber(email)
                .stream()
                .map(Subscription::getSubscribeTo)
                .collect(Collectors.toList());
        Map<String, List<String>> map = new HashMap<>();
        map.put("subscribers", subs);
        return map;
    }
}
