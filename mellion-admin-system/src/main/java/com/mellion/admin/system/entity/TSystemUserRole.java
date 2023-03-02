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
 * 系统用户和角色关联实体类
 *
 * @author MellionPG
 * @date 2023/3/2 15:18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统用户和角色关联")
public class TSystemUserRole extends BaseEntity {

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @NotNull(message = "用户ID不能为空")
    private Long userId;

    /**
     * 角色ID
     */
    @ApiModelProperty("角色ID")
    @NotNull(message = "角色ID不能为空")
    private Long roleId;

}
