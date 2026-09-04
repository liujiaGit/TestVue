package com.example.testvue.controller;


import com.example.testvue.untils.Result;
import com.example.testvue.service.SysDiscService;
import com.example.testvue.entity.SysDisc;
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
@RequestMapping("/sysDisc")
@Api(tags = "字典表管理")
public class SysDiscController {

        @Resource
        private SysDiscService sysDiscService;

        @ApiOperation("字典表-添加")
        @PostMapping("/add")
        public Result<Integer> add(@RequestBody SysDisc sysDisc){
            sysDiscService.add(sysDisc);
            return Result.ok();
        }

        @ApiOperation("字典表-删除")
        @DeleteMapping("/delete/{id}" )
        public Result<Integer> delete(@PathVariable String id){
            sysDiscService.removeById(id);
            return Result.ok();
        }

        @ApiOperation("字典表-修改")
        @PutMapping("/update/{id}" )
        public Result<SysDisc> update(@PathVariable String id){
            sysDiscService.updateById(id);
            return Result.ok();
        }

        @ApiOperation("字典表-列表")
        @GetMapping("/pageList" )
        public Result<PageInfo<SysDisc>> list(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize){
            PageHelper.startPage(pageIndex,pageSize);
            List<SysDisc> list= sysDiscService.list();
            return Result.success(new PageInfo<>(list));
        }

}
