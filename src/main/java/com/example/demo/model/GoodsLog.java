package com.example.demo.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName GoodsLog
 * @Description 实体
 * @Author tianlg
 * @Date 2020/11/15 14:26
 * @Version 1.0
 **/
@Data
@Alias("goodsLog")
public class GoodsLog {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 日期
     */
    @Excel(name = "日期")
    private String data;
    /**
     * 车牌号
     */
    @Excel(name = "车号")
    private String code;
    /**
     * 重量
     */
    @Excel(name = "吨数")
    private BigDecimal weight;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     *
     */
    private Integer checkStatus;

}
