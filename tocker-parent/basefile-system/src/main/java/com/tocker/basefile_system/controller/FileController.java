package com.tocker.basefile_system.controller;

import com.tocker.basefile_system.service.Fileservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FileController {

    @Autowired
    private Fileservice fileservice;

    @PostMapping("upload")
    public Map<String,Object> upload(MultipartFile file){
        HashMap<String, Object> map = new HashMap<>();
        String path = this.fileservice.uploadImage(file);
        map.put("path",path);
        return map;
    }
}
