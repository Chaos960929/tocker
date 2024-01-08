package com.tocker.basefile_system.service.impl;

import com.github.tobato.fastdfs.domain.upload.FastImageFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.tocker.basefile_system.service.Fileservice;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Slf4j
@Service
public class FileServiceImpl implements Fileservice {

    @Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Override
    public String uploadImage(MultipartFile file) {
        try {
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (null == image || image.getHeight() == 0 || image.getWidth() == 0) {
                throw new RuntimeException("文件不是图片");
            }
        } catch (IOException e) {
            log.error("上传文件失败!", e);
        }
        try {
            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
        } catch (Exception e) {

        }
        return null;
    }

    public void initConfig(){

    }
}
