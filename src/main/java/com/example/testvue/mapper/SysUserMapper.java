package com.example.testvue.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.example.testvue.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author LIUJIA
 * @since 2026-07-09
 */
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    int insert(SysUser sysUser);
    int deleteById(@Param("id") Integer id);
    List<SysUser> findAll();

    SysUser updateById(Integer id);
}
