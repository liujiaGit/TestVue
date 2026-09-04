package com.example.testvue.service;

import com.example.testvue.entity.SysDisc;
import com.example.testvue.mapper.SysDiscMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
public class SysDiscService {
    @Autowired
    private SysDiscMapper sysDiscMapper;

    public int add(@RequestBody SysDisc sysDisc) {
        return sysDiscMapper.add(sysDisc);
    }
    public int removeById(String id){
        return sysDiscMapper.removeById(id);
    }

    public int updateById(String id) {
        return sysDiscMapper.updateById(id);
    }

    public List<SysDisc> list() {
        return sysDiscMapper.list();
    }
}
