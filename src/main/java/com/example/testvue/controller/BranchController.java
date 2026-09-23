package com.example.testvue.controller;

import com.example.testvue.entity.Branch;
import com.example.testvue.entity.SysDisc;
import com.example.testvue.untils.Result;
import com.example.testvue.service.BranchService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/api/branch")
public class BranchController {
    @Autowired
    private BranchService branchService;

    @PostMapping("/pageList")
    public Result<PageInfo<Branch>> findAll(@RequestBody Branch branch, @RequestParam(defaultValue = "1") Integer pageIndex, @RequestParam(defaultValue = "10") Integer pageSize) {
       log.info("branch=="+branch);
        PageHelper.startPage(pageIndex,pageSize);
        List<Branch> list= branchService.findAll(branch);
        log.info("list:" + list);
        return Result.success(new PageInfo(list));
    }

    @ApiOperation("部门表-修改")
    @PatchMapping("/update" )
    public Result<SysDisc> update(@RequestBody Branch branch){
        branchService.updateById(branch);
        return Result.ok();
    }
    @ApiOperation("部门表-删除")
    @DeleteMapping("/delete" )
    public Result<SysDisc> deleteById(@RequestParam("branchId") String branchId){
        branchService.deleteById(branchId);
        return Result.ok();
    }
}
