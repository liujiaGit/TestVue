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
 * 
 * </p>
 *
 * @author LIUJIA
 * @since 2026-09-06
 */
@Data
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@TableName("the_table_info_data")
@ApiModel(value="TheTableInfoData对象", description="")
public class TheTableInfoData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一标识ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "数据源名称")
    private String title;

    @ApiModelProperty(value = "数值")
    private Integer infoData;

    @ApiModelProperty(value = "涨幅")
    private Float rate;

    @ApiModelProperty(value = "图片")
    private String img;


}
