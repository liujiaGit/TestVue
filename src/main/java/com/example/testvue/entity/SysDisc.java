package com.example.testvue.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author LIUJIA
 * @since 2026-07-09
 */
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("sys_disc")
@ApiModel(value="SysDisc对象", description="字典表")
public class SysDisc implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "字典编号")
    private String discNo;

    @ApiModelProperty(value = "字典名")
    private String discName;


}
