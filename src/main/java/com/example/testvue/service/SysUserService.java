package com.example.testvue.service;

import com.example.testvue.entity.SysUser;
import com.example.testvue.mapper.SysUserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public int insert(SysUser sysUser){
        return sysUserMapper.insert(sysUser);
    }
    public Boolean removeById(@Param("id") Integer id){
        int count = sysUserMapper.deleteById(id);
        Boolean flag;
        if(count == 1){
           return true;
        }else{
            return false;
        }
    }
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    public int updateById(SysUser sysUser) {
        return sysUserMapper.updateById(sysUser);
    }
}
