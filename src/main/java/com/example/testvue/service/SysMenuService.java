package com.example.testvue.service;

import com.example.testvue.entity.SysMenu;
import com.example.testvue.mapper.SysMenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author LIUJIA
 * @since 2026-07-09
 */
@Service
public class SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    public int save(SysMenu sysMenu){
        return sysMenuMapper.save(sysMenu);
    }
    public int removeById(int id) {
        return sysMenuMapper.deleteById(id);
    }
    public int updateById(String id, SysMenu sysMenu) {
        return sysMenuMapper.updateById(id,sysMenu);
    }
    public List<SysMenu> list() {
        return sysMenuMapper.list();
    }
}
