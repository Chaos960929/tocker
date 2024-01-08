package com.tocker.corebase.util;

;
import com.alibaba.excel.EasyExcel;
import com.tocker.corebase.listener.ExcelListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
public class ExcelUtil {

    /**
     * 读取Excel的数据
     *
     * @return
     */
    public static List<T> readExcel(MultipartFile file, Class<T> clazz) {
        ExcelListener<T> excelListener = null;
        try {
            InputStream inputStream = file.getInputStream();
            excelListener = new ExcelListener();
            EasyExcel.read(inputStream, clazz, excelListener).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<T> result = excelListener.getData();
        return result;
    }

    /**
     * 读取Excel的数据
     *
     * @return
     */
    public static List<T> readExcel(MultipartFile file, Class<T> clazz, ExcelListener<T> excelListener) {
        try {
            InputStream inputStream = file.getInputStream();
            excelListener = new ExcelListener();
            EasyExcel.read(inputStream, clazz, excelListener).sheet().doRead();
        } catch (IOException e) {
            log.error("读取excel数据失败!");
        }
        List<T> result = excelListener.getData();
        return result;
    }

    /**
     * 写excel数据
     *
     * @param fileName
     * @param list
     * @param clazz
     */
    public static void writeExcel(String fileName, List<T> list, Class<T> clazz) {
        try {
            EasyExcel.write(fileName, clazz).sheet("模板").doWrite(list);
        } catch (Exception e) {
            log.error("读取excel数据失败!");
        }
    }


    /**
     * 写excel数据
     *
     * @param response
     * @param list
     * @param clazz
     * @throws IOException
     */
    public void writeExcel(HttpServletResponse response, List<T> list, Class<T> clazz) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), clazz).sheet("模板").doWrite(list);
    }
}
