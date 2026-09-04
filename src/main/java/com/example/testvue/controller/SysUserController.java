package com.example.testvue.controller;

import com.example.testvue.untils.Result;
import com.example.testvue.service.SysUserService;
import com.example.testvue.entity.SysUser;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.github.pagehelper.PageHelper;
import java.util.List;

/**
 *
 * @author LIUJIA
 * @since 2026-07-09
 */
@RestController
@RequestMapping("/sysUser")
@Api(tags = "用户表管理")
public class SysUserController {

        @Resource
        private SysUserService sysUserService;

        @ApiOperation("用户表-添加")
        @PostMapping("/add")
        public Result<Integer> add(@RequestBody SysUser sysUser){
            int count = sysUserService.insert(sysUser);
            return Result.ok();
        }

        @ApiOperation("用户表-删除")
        @DeleteMapping("/delete" )
        public Result<Integer> delete(@RequestParam Integer id){
            Boolean flag = sysUserService.removeById(id);
            return Result.ok();
        }

        @ApiOperation("用户表-修改")
        @PutMapping("/update" )
        public Result<Integer> update(@RequestBody SysUser sysUser){
            sysUserService.updateById(sysUser);
            return Result.ok();
        }

        @ApiOperation("用户表-列表")
        @GetMapping("/pageList" )
        public Result<PageInfo<SysUser>> findAll(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize){
            PageHelper.startPage(pageIndex,pageSize);
            List<SysUser> list= sysUserService.findAll();
            return Result.success(new PageInfo<>(list));
        }

}
