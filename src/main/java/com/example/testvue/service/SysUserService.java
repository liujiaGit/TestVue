package com.example.testvue.service;

import com.example.testvue.entity.SysUser;
import com.example.testvue.mapper.SysUserMapper;
import com.example.testvue.untils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author LIUJIA
 * @since 2026-07-09
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    public List<SysUser> login(SysUser sysUser) {
        
        return sysUserMapper.login(sysUser);
    }
}
