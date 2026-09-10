package com.example.testvue.mapper;

import com.example.testvue.entity.TheTableInfoData;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LIUJIA
 * @since 2026-09-06
 */
@Mapper
@Repository
public interface TheTableInfoDataMapper extends BaseMapper<TheTableInfoData> {
    List<TheTableInfoData> selectList();
}
