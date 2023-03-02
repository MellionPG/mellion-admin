package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统部门实体类
 *
 * @author MellionPG
 * @date 2023/3/2 15:34
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统部门")
public class TSystemDept extends BaseEntity {

    /**
     * 父级部门ID
     */
    @ApiModelProperty("父级部门ID")
    private Long parentId;

    /**
     * 负责人ID
     */
    @ApiModelProperty("负责人ID")
    private Long leaderUserId;

    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String name;

    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    private String phoneNumber;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

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
