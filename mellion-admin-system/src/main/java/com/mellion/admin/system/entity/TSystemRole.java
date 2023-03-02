package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import com.mellion.admin.system.annotation.DictDefineProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(message = "角色编码不能为空")
    @Size(max = 64, message = "角色编码长度不能超过64位")
    private String code;

    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @NotNull(message = "角色名称不能为空")
    @Size(max = 32, message = "角色名称长度不能超过32位")
    private String name;

    /**
     * 数据权限范围(枚举)
     */
    @ApiModelProperty("数据权限范围(枚举)")
    @DictDefineProperty(dictCode = "data_type")
    @NotNull(message = "数据权限范围不能为空")
    private Integer dataScope;

    /**
     * 角色类型(枚举)
     */
    @ApiModelProperty("角色类型(枚举)")
    @DictDefineProperty(dictCode = "role_type")
    private Integer roleType;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Size(max = 256, message = "备注信息不能超过256位")
    private String remark;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    @DictDefineProperty(dictCode = "status")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
