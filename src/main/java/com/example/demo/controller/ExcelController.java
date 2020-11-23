package com.example.demo.controller;

import com.example.demo.model.GoodsLog;
import com.example.demo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ExcelController
 * @Description 文档接口
 * @Author tianlg
 * @Date 2020/11/15 14:46
 * @Version 1.0
 **/

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        return excelService.fileUpload(file);
    }

    @PutMapping("")
    public Integer updateById(@RequestBody GoodsLog goodsLog) {
        return excelService.updateById(goodsLog);
    }

    @GetMapping(value = "/by")
    public List<GoodsLog> selectByCode(@RequestParam("code") String code) {
        return excelService.selectByCode(code);
    }

    @PutMapping(value = "/check")
    public List<GoodsLog> bulkCheck(@RequestBody List<Long> Ids) {
        return excelService.bulkCheck(Ids);
    }

    @PutMapping(value = "/unCheck")
    public List<GoodsLog> bulkUnCheck(@RequestBody List<Long> Ids) {
        return excelService.bulkUnCheck(Ids);
    }

    @GetMapping(value = "downLoadExcel")
    public void downLoadExcel(HttpServletResponse response) {
        excelService.downLoadExcel(response);
    }
}
