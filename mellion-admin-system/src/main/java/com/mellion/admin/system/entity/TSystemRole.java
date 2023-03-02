package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统角色实体类
 *
 * @author MellionPG
 * @date 2023/3/2 15:12
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统角色")
public class TSystemRole extends BaseEntity {

    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String code;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;

    /**
     * 数据权限范围(枚举)
     */
    @ApiModelProperty("数据权限范围(枚举)")
    private Integer dataScope;

    /**
     * 角色类型(枚举)
     */
    @ApiModelProperty("角色类型(枚举)")
    private Integer roleType;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    private Integer status;

}
