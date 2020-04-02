package com.netcracker.ncedu.tlt.impl.photohub.controller;

import com.netcracker.ncedu.tlt.impl.photohub.model.ContentRepository;
import com.netcracker.ncedu.tlt.impl.photohub.model.Photo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/api/contentfeed")
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;

    @GetMapping(path = "/get_content")
    @ResponseBody
    public Object getImagesById(@RequestParam Integer id, String email) throws IOException {
        List<String> images = contentRepository.findByEmailAndId(id)
                .stream()
                .map(Photo::getBase64)
                .collect(Collectors.toList());
        Map<String, List<String>> map = new HashMap<>();
        map.put("images", images);
        return map;
    }
}
