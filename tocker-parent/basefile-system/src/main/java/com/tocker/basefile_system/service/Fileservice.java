package com.tocker.basefile_system.service;

import org.springframework.web.multipart.MultipartFile;

public interface Fileservice {

    String uploadImage(MultipartFile file);
}
