package com.example.testvue.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.testvue.entity.Branch;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BranchMapper extends BaseMapper<Branch> {
    List<Branch> findAll(Branch branch);
    int updateById(Branch branch);
    int deleteById(String branchId);

}
