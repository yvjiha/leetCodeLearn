package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.GoodsLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsLogMapper extends BaseMapper<GoodsLog> {
    /**
     * 批量删除
     *
     * @param ids
     */
    void bulkDel(@Param("ids") List<Long> ids);
}
