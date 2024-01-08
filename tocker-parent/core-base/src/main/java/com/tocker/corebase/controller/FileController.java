//package com.tocker.corebase.controller;
//
//
//import com.tocker.corebase.vo.ResultVo;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * 文件上传下载 controller
// * @author jerry
// */
//@Api(value = "文件传输", tags = "文件传输")
//@RequestMapping("/file")
//public interface FileController {
//
//    /**
//     * 上传
//     * @param file 文件
//     * @return 文件路径
//     * @throws IOException 异常
//     */
//    @ApiOperation(value = "上传", notes = "上传")
//    @PostMapping("/upload")
//    ResultVo<String> upload(MultipartFile file) throws IOException;
//
//    /**
//     * 上传并返回文件路径和文件名
//     * @param file 文件
//     * @return 文件路径
//     * @throws IOException 异常
//     */
//    @ApiOperation(value = "上传并返回文件路径和文件名", notes = "上传并返回文件路径和文件名")
//    @PostMapping("/upload/info")
//    ResultVo<Map<String, String>> uploadAndInfo(MultipartFile file) throws IOException;
//
//    /**
//     * 获取缩略图路径
//     * @param fullPath 文件路径
//     * @return 缩略图路径
//     */
//    @ApiOperation(value = "缩略图路径", notes = "缩略图路径")
//    @GetMapping("/thumbImagePath")
//    ResultVo<String> getThumbImagePath(@ApiParam(value = "文件路径", required = true) @RequestParam String fullPath);
//
//    /**
//     * 下载
//     * @param fullPath 文件路径
//     * @param response 请求响应
//     * @throws IOException 异常
//     */
//    @ApiOperation(value = "下载", notes = "下载")
//    @GetMapping(value = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    void download(@ApiParam(value = "文件路径", required = true) @RequestParam String fullPath, HttpServletResponse response) throws IOException;
//
//    /**
//     * 删除
//     * @param fullPath 文件路径
//     */
//    @ApiOperation(value = "删除", notes = "删除")
//    @DeleteMapping("/delete")
//    void delete(@ApiParam(value = "文件路径", required = true) @RequestParam String fullPath);
//
//    /**
//     * 下载缩略图
//     * @param fullPath 文件路径
//     * @param response 请求响应
//     * @throws IOException 异常
//     */
//    @ApiOperation(value = "下载缩略图", notes = "下载缩略图")
//    @GetMapping(value = "/download/thunimage", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    void downloadThubImagePath(@ApiParam(value = "文件路径", required = true) @RequestParam String fullPath, HttpServletResponse response) throws IOException;
//}
//
//
