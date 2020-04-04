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
    @Autowired
    private AvatarRepository avatarRepository;

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
        List<String> images = photoRepository.findByEmail(email)
        .stream()
        .map(Photo::getBase64)
        .collect(Collectors.toList());
        Map<String, List<String>> map = new HashMap<>();
        map.put("images", images);
        return map;
    }

    @PostMapping(path = "/upload/avatar")
    public void addProfile(@RequestBody UploadData profile, HttpServletResponse response) throws IOException {
        if(avatarRepository.existsByEmailAndBase64(profile.getEmail(), profile.getBase64())) {
            response.sendError(409, "Такое изображение уже загружено" );
        }

        else { Avatar avatar =  new Avatar();
            avatar.setEmail(profile.getEmail());
            avatar.setBase64(profile.getBase64());
            avatarRepository.save(avatar);
        }
    }

    @GetMapping(path = "/get/avatar")
    @ResponseBody
    public Object getImagesByEmailFromAvatar(@RequestParam String email,HttpServletResponse response) throws IOException {
        String avatar = avatarRepository.findByEmail(email)
                .stream()
                .map(Avatar::getBase64)
                .findFirst()
                .orElse("");
        if (avatar.isEmpty()) {
            response.sendError(404, "Not found" );
        }

        Map<String,String> responseBody = new HashMap<>();
        responseBody.put("avatar", avatar);
        return responseBody;

    }


}