package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 系统角色和菜单关联表
 *
 * @author MellionPG
 * @date 2023/3/2 15:30
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统角色和菜单关联")
public class TSystemRoleMenu extends BaseEntity {

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

    /**
     * 菜单ID
     */
    @ApiModelProperty("菜单ID")
    @NotNull(message = "菜单ID不能为空")
    private Long menuId;

}
