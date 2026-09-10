package com.example.testvue.controller;


import com.example.testvue.service.TheTableInfoDataService;
import com.example.testvue.entity.TheTableInfoData;
import com.example.testvue.untils.Result;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import com.github.pagehelper.PageHelper;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author LIUJIA
 * @since 2026-09-06
 */
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/theTableInfoData")
public class TheTableInfoDataController {

        @Resource
        private TheTableInfoDataService theTableInfoDataService;

        @ApiOperation("-列表查询")
        @PostMapping("/list" )
        public Result<List<TheTableInfoData>> list(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize){
            PageHelper.startPage(pageIndex,pageSize);
            List<TheTableInfoData> list= theTableInfoDataService.list();
            return Result.success(list);
        }

}
