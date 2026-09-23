package com.example.testvue.controller;

import com.example.testvue.untils.Result;
import com.example.testvue.service.SysUserService;
import com.example.testvue.entity.SysUser;
import com.example.testvue.untils.ResultCode;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * @author LIUJIA
 * @since 2026-07-09
 */
@Slf4j
@RestController
@RequestMapping("/api/sysUser")
@Api(tags = "用户表管理")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;


    @ApiOperation("用户表-列表")
    @GetMapping("/pageList")
    public Result<PageInfo<SysUser>> findAll(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<SysUser> list = sysUserService.findAll();
        return Result.success(new PageInfo<>(list));
    }

    @ApiOperation("用户表-登录请求")
    @PostMapping("/login")
    public Result<List<SysUser>> login(@RequestBody SysUser sysUser) {
        log.info("登录请求参数" + sysUser);
        List<SysUser> list = sysUserService.login(sysUser);
        log.info("登录请求返回的list" + list);
        if (!list.isEmpty()) {
            return Result.success(list);
        } else {
            return Result.error(ResultCode.USER_ACCOUNT_ERROR.code,ResultCode.USER_ACCOUNT_ERROR.msg);
        }
    }
}
