package com.example.testvue.controller;


import com.example.testvue.untils.Result;
import com.example.testvue.service.SysMenuService;
import com.example.testvue.entity.SysMenu;
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
@RequestMapping("/sysMenu")
@Api(tags = "字典表管理")
public class SysMenuController {

        @Resource
        private SysMenuService sysMenuService;

        @ApiOperation("字典表-添加")
        @PostMapping("/add")
        public Result<Integer> add(@RequestBody SysMenu sysMenu){
                sysMenuService.save(sysMenu);
            return Result.ok();
        }
        @ApiOperation("字典表-删除")
        @DeleteMapping("/delete/{id}" )
        public Result<Integer> delete(@PathVariable Integer id){
                sysMenuService.removeById(id);
            return Result.ok();
        }
        @ApiOperation("字典表-修改")
        @PutMapping("/update/{id}" )
        public Result<Integer> update(@PathVariable String id,@RequestBody SysMenu sysMenu){
                sysMenuService.updateById(id,sysMenu);
            return Result.ok();
        }
        @ApiOperation("字典表-列表")
        @GetMapping("/pageList" )
        public Result<PageInfo<SysMenu>> list(@RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize){
            PageHelper.startPage(pageIndex,pageSize);
            List<SysMenu> list= sysMenuService.list();
            return Result.success(new PageInfo<>(list));
        }

}
