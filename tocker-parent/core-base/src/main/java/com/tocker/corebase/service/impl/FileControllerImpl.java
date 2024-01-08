//package com.tocker.corebase.service.impl;
//
//
//import com.github.tobato.fastdfs.domain.fdfs.MetaData;
//import com.github.tobato.fastdfs.domain.fdfs.StorePath;
//import com.github.tobato.fastdfs.domain.fdfs.ThumbImageConfig;
//import com.github.tobato.fastdfs.domain.proto.storage.DownloadByteArray;
//import com.github.tobato.fastdfs.service.FastFileStorageClient;
//import com.tocker.corebase.vo.ResultVo;
//import io.swagger.annotations.ApiParam;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.io.FilenameUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.util.Map;
//import java.util.Set;
//
///**
// * 文件上传下载 controller
// * @author jerry
// */
//@Slf4j
//@RestController
//public class FileControllerImpl implements FileController {
//
//    /** 文件服务器 客户端 */
//    @Autowired
//    private FastFileStorageClient storageClient;
//
//    /** 缩略图 配置 */
//    @Autowired
//    private ThumbImageConfig thumbImageConfig;
//
//    /** 文件名称 */
//    private static final String META_DATA_NAME_FILE_NAME = "FILE_NAME";
//
//    @Autowired
//    private FileService fileService;
//
//    @Override
//    public ResultVo<String> upload(MultipartFile file) throws IOException {
//        Map<String, String> result = fileService.uploadFile(file);
//        return ResultVo.ok("上传成功！", result.get("uri"));
//    }
//
//    @Override
//    public ResponseInfo<Map<String, String>> uploadAndInfo(MultipartFile file) throws IOException {
//        Map<String, String> result = fileService.uploadFile(file);
//        return ResponseInfo.ofOk("上传成功！", result);
//    }
//
//    @Override
//    public ResponseInfo<String> getThumbImagePath(@RequestParam String fullPath) {
//        StorePath storePath = StorePath.parseFromUrl(fullPath);
//        return ResponseInfo.ofOk(HttpResponseStatus.SC_OK.getMessage(), thumbImageConfig.getThumbImagePath(storePath.getFullPath()));
//    }
//
//    @Override
//    public void  download(@ApiParam(value = "文件路径", required = true) @RequestParam String fullPath, HttpServletResponse response) throws IOException {
//        StorePath storePath = StorePath.parseFromUrl(fullPath);
//        Set<MetaData> metaDataSet = storageClient.getMetadata(storePath.getGroup(), storePath.getPath());
//        String fileName = metaDataSet.stream().findFirst()
//                .filter(metaData -> META_DATA_NAME_FILE_NAME.equals(metaData.getName()))
//                .map(MetaData::getValue)
//                .orElse(FilenameUtils.getName(fullPath));
//        byte[] bytes = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), new DownloadByteArray());
//
//        response.reset();
//        response.setContentType("multipart/form-data;charset=UTF-8;");
//        fileName = new String(fileName.getBytes("gb2312"), "ISO8859-1");
//        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//        try (OutputStream outputStream = response.getOutputStream()) {
//            outputStream.write(bytes);
//        }
//    }
//
//    @Override
//    public void delete(@ApiParam(value = "文件路径", required = true) @RequestParam String fullPath) {
//        storageClient.deleteFile(fullPath);
//    }
//
//    /**
//     * 下载缩略图
//     * @param fullPath 文件路径
//     * @param response 请求响应
//     * @throws IOException
//     */
//    @Override
//    public synchronized void downloadThubImagePath(String fullPath, HttpServletResponse response) throws IOException {
//        StorePath storePath = StorePath.parseFromUrl(fullPath);
//        String path = thumbImageConfig.getThumbImagePath(storePath.getFullPath());
//        this.download(path,response);
//    }
//
//
//}
//
//
