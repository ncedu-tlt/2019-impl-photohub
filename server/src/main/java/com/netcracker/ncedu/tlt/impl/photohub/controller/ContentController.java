package com.netcracker.ncedu.tlt.impl.photohub.controller;

import com.netcracker.ncedu.tlt.impl.photohub.model.Photo;
import com.netcracker.ncedu.tlt.impl.photohub.model.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.*;


@Controller
@RequestMapping(path="/api/contentfeed")
public class ContentController {
    @Autowired
    private PhotoRepository photoRepository;
    @GetMapping(path = "/get_content")
    @ResponseBody
    public Object getImagesById() throws IOException {
        List <Object> response = new ArrayList<>();
        for (Photo photo : photoRepository.findAll()) {
            Map<String,String> object = new HashMap<>();
            object.put("email",photo.getEmail());
            object.put("base64",photo.getBase64());
            response.add(object);
        }
        return response;
    }
}
