package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.ExcelUtils;
import com.example.demo.common.Utils;
import com.example.demo.mapper.GoodsLogMapper;
import com.example.demo.model.GoodsLog;
import com.example.demo.service.ExcelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ExcelServiceImpl
 * @Description 文档处理
 * @Author tianlg
 * @Date 2020/11/15 13:57
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class ExcelServiceImpl implements ExcelService {

    @Autowired
    private GoodsLogMapper goodsLogMapper;

    /**
     * @Description: 上传/导入
     * @Param:
     * @return:
     * @Author: tianlg
     * @Date: 2020/11/15
     **/
    @Override
    public ResponseEntity fileUpload(MultipartFile file) throws IOException {
        if (!Utils.checkExtension(file)) {
            return new ResponseEntity("请求文件类型错误:后缀名错误", HttpStatus.BAD_REQUEST);
        }
        List<GoodsLog> GoodsLogs = ExcelUtils.importExcel(file, 0, 1, true, GoodsLog.class);
        for (GoodsLog goodsLog : GoodsLogs) {
            goodsLog.setCreateTime(new Date());
            goodsLogMapper.insert(goodsLog);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * @Description: 下载/导出
     * @Param:
     * @return:
     * @Author: tianlg
     * @Date: 2020/11/15
     **/
    @Override
    public void downLoadExcel(HttpServletResponse response) {

    }

    /**
     * @Description:
     * @Param:
     * @return:
     * @Author: tianlg
     * @Date: 2020/11/15
     **/
    @Override
    public List<GoodsLog> selectByCode(String code) {
        if (StringUtils.isBlank(code)) {
            return goodsLogMapper.selectList(new LambdaQueryWrapper<GoodsLog>().orderByDesc(GoodsLog::getCreateTime).last("LIMIT 20"));
        } else {
            return goodsLogMapper.selectList(new LambdaQueryWrapper<GoodsLog>().eq(GoodsLog::getCode, code));
        }
    }

    @Override
    public List<GoodsLog> bulkCheck(List<Long> ids) {
        for (Long id : ids) {
            GoodsLog goodsLog = new GoodsLog();
            goodsLog.setId(id);
            goodsLog.setCheckStatus(1);
            goodsLogMapper.updateById(goodsLog);
        }
        return null;
    }

    @Override
    public List<GoodsLog> bulkUnCheck(List<Long> ids) {
        for (Long id : ids) {
            GoodsLog goodsLog = new GoodsLog();
            goodsLog.setId(id);
            goodsLog.setCheckStatus(0);
            goodsLogMapper.updateById(goodsLog);
        }
        return null;
    }

    /**
     * 修改
     *
     * @param goodsLog
     * @return
     */
    @Override
    public Integer updateById(GoodsLog goodsLog) {
        return goodsLogMapper.updateById(goodsLog);
    }
}
