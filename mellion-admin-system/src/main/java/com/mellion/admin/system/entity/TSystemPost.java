package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统岗位实体类
 *
 * @author MellionPG
 * @date 2023/3/2 15:38
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统岗位")
public class TSystemPost extends BaseEntity {

    /**
     * 岗位编码
     */
    @ApiModelProperty("岗位编码")
    private String code;

    /**
     * 岗位名称
     */
    @ApiModelProperty("岗位名称")
    private String name;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer sortNumber;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    private Integer status;

}
