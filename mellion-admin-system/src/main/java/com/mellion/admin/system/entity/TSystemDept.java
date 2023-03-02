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
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @NotNull
    @Size(max = 64, message = "部门名称长度不能超过64位")
    private String name;

    /**
     * 电话号码
     */
    @ApiModelProperty("电话号码")
    @Size(max = 16, message = "电话号码长度不能超过16位")
    private String phoneNumber;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",
            message = "电子邮箱格式有误")
    private String email;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    @NotNull(message = "显示顺序不能为空")
    private Integer sortNumber;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    @DictDefineProperty(dictCode = "status")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
