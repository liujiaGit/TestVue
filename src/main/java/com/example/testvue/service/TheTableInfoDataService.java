package com.example.testvue.service;

import com.example.testvue.entity.TheTableInfoData;
import com.example.testvue.mapper.TheTableInfoDataMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LIUJIA
 * @since 2026-09-06
 */
@Service
public class TheTableInfoDataService {
    @Autowired
    private TheTableInfoDataMapper theTableInfoDataMapper;

    public List<TheTableInfoData> list() {
        return theTableInfoDataMapper.selectList();
    }
}
