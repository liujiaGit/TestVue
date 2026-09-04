package com.example.testvue.mapper;

import com.example.testvue.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    int save(SysMenu sysMenu);

    int updateById(String id);

    List<SysMenu> list();

    int updateById(String id, SysMenu sysMenu);
}
