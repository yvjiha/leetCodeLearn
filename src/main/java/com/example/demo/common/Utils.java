package com.example.demo.common;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.FileMagic;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Lists;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @ClassName Utils
 * @Description 工具类
 * @Author tianlg
 * @Date 2020/11/15 14:43
 * @Version 1.0
 **/
public class Utils {
    /**
     * 判断是否office文件
     * @param inputStream
     * @return
     */
    public static Boolean isOfficeFile(InputStream inputStream){
        boolean result = false;
        try {
            FileMagic fileMagic = FileMagic.valueOf(inputStream);
            if (Objects.equals(fileMagic,FileMagic.OLE2)||Objects.equals(fileMagic,fileMagic.OOXML)){
                result = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断是否office文件
     * @param file
     * @return
     * @throws IOException
     */
    public static Boolean isOfficeFile(MultipartFile file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(file.getInputStream());
        boolean result = false;
        result = isOfficeFile(bufferedInputStream);
        return result;
    }

    /**
     * 判断扩展名是否是excel扩展名
     * @param extension
     * @return
     */
    public static Boolean checkExtension(String extension){
        return Lists.newArrayList("xls","xlsx","XLS","XLSX").contains(extension);
    }

    /**
     * 判断扩展名是否是excel扩展名
     * @param file
     * @return
     */
    public static Boolean checkExtension(MultipartFile file){
        String fileName = file.getOriginalFilename();
        String extension = fileName.substring(fileName.lastIndexOf(".")+1);
        return checkExtension(extension);
    }

    /**
     * 自动判断文件类型
     * @param file
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbookAuto(MultipartFile file) throws IOException {
        /** 判断文件的类型，是2003还是2007 */
        boolean isExcel2003 = true;
        if (isExcel2007(file.getOriginalFilename())) {
            isExcel2003 = false;
        }
        BufferedInputStream is = new BufferedInputStream( file.getInputStream());
        Workbook wb;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        return wb;
    }

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}