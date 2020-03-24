package com.netcracker.ncedu.tlt.impl.photohub.controller;
import com.netcracker.ncedu.tlt.impl.photohub.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/api/image")
public class ImageController {
    @Autowired
    private PhotoRepository photoRepository;

    @PostMapping(path = "/upload")
    public void addImage(@RequestBody UploadData uploadData, HttpServletResponse response) throws IOException {
        if(photoRepository.existsByEmailAndBase64(uploadData.getEmail(), uploadData.getBase64())) {
            response.sendError(409, "Такое изображение уже загружено" );
        }

        else { Photo photo =  new Photo();
        photo.setEmail(uploadData.getEmail());
        photo.setBase64(uploadData.getBase64());
            photoRepository.save(photo);
            photo.setDate(new Date());
                 }
    }
    @GetMapping(path = "/get")
    @ResponseBody
    public Object getImagesByEmail(@RequestParam String email) throws IOException {
        return photoRepository.findByEmail(email)
        .stream()
        .map(Photo::getBase64)
        .collect(Collectors.toList());
    }
}