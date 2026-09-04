package com.example.testvue.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class Branch implements Serializable {
    private static final long serialVersionUID = 1L;
    private int branchId;
    private String lastRoleNo;
    private String lastRoleName;
    private String branchNo;
    private String branchName;
    private String perNo;
    private String perName;

}
