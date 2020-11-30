package com.example.demo.service;

import com.example.demo.model.GoodsLog;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public interface ExcelService {
    /**
     * 上传/导入
     *
     * @param file
     * @return
     */
    ResponseEntity fileUpload(MultipartFile file) throws IOException;

    /**
     * 下载/导出
     *
     * @param response
     */
    void downLoadExcel(HttpServletResponse response);

    /**
     * @Description: 查询列表
     * @Param:
     * @return:
     * @Author: tianlg
     * @Date: 2020/11/15
     **/
    List<GoodsLog> selectByCode(String code);

    List<GoodsLog> bulkCheck(List<Long> ids);

    List<GoodsLog> bulkUnCheck(List<Long> ids);

    /**
     * 修改
     *
     * @param goodsLog
     * @return
     */
    Integer updateById(GoodsLog goodsLog);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    void bulkDel(List<Long> ids);
}
