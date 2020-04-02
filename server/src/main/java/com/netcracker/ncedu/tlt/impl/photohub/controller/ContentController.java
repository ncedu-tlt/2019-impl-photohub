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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(path="/api/contentfeed")
public class ContentController {
    @Autowired
    private PhotoRepository photoRepository;
    @GetMapping(path = "/get_content")
    @ResponseBody
    public Object getImagesById(@RequestParam Integer id, String email) throws IOException {
        List<String> images = new LinkedList<>();
        for (Photo photo : photoRepository.findAll()) {
            images.add(photo.getBase64());
        }
        Map<String, List<String>> map = new HashMap<>();
        map.put("images", images);
        return map;
    }
}
