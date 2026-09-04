package com.example.testvue.service;

import com.example.testvue.entity.Branch;
import com.example.testvue.mapper.BranchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService  {
    @Autowired
    private BranchMapper branchMapper;

    public List<Branch> findAll() {
        return branchMapper.findAll();
    }

    public int updateById(Branch branch) {
        return branchMapper.updateById(branch);
    }

    public int deleteById(String branchId) {
        return branchMapper.deleteById(branchId);
    }
}
