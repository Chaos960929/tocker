//package com.tocker.corebase.service.impl;
//
//import com.github.tobato.fastdfs.domain.fdfs.MetaData;
//import com.github.tobato.fastdfs.domain.fdfs.StorePath;
//import com.github.tobato.fastdfs.service.FastFileStorageClient;
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Set;
//
//@Service
//public class FileServiceImpl implements FileService {
//
//    /** 图片后缀集合 */
//    private static final Set<String> IMAGE_PREFIX_SET = Set.of("JPG", "JPEG", "PNG", "GIF", "BMP", "WBMP");
//
//    /** 文件服务器 客户端 */
//    @Autowired
//    private FastFileStorageClient storageClient;
//
//    /** 文件名称 */
//    private static final String META_DATA_NAME_FILE_NAME = "FILE_NAME";
//
//    @Override
//    public Map<String, String> uploadFile(MultipartFile file) throws IOException {
//        String fileName = file.getOriginalFilename();
//        String filePrefix = FilenameUtils.getExtension(fileName);
//        StorePath storePath;
//        if (IMAGE_PREFIX_SET.contains(filePrefix.toUpperCase())) {
//            // 图片上传并且生成缩略图
//            storePath = this.storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), filePrefix, Collections.singleton(new MetaData(META_DATA_NAME_FILE_NAME, fileName)));
//        } else {
//            // 普通文件上传
//            storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), filePrefix, Collections.singleton(new MetaData(META_DATA_NAME_FILE_NAME, fileName)));
//        }
//        Map<String, String> result = new HashMap<>();
//        result.put("uri", storePath.getFullPath());
//        result.put("name", fileName);
//        return result;
//    }
//}
//
//
