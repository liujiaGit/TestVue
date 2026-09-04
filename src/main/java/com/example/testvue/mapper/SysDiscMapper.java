package com.example.testvue.mapper;

import com.example.testvue.entity.SysDisc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 字典表 Mapper 接口
 * </p>
 *
 * @author LIUJIA
 * @since 2026-07-09
 */
@Mapper
@Repository
public interface SysDiscMapper extends BaseMapper<SysDisc> {
    int add(SysDisc sysDisc);
    int removeById(String id);
    int updateById(String id);
    List<SysDisc> list();
}
