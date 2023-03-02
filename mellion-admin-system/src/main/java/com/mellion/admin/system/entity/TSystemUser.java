package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 系统用户实体类
 *
 * @author MellionPG
 * @date 2023/3/2 14:59
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统用户")
public class TSystemUser extends BaseEntity {

    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private Long postId;

    /**
     * 岗位ID
     */
    @ApiModelProperty("岗位ID")
    private Long deptId;

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 性别(枚举)
     */
    @ApiModelProperty("性别(枚举)")
    private Integer sex;

    /**
     * 出生年月日
     */
    @ApiModelProperty("出生年月日")
    private LocalDate birthdate;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobileNumber;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    private String email;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String avatar;

    /**
     * 最后登录IP
     */
    @ApiModelProperty("最后登录IP")
    private String loginIp;

    /**
     * 最后登录时间
     */
    @ApiModelProperty("最后登录时间")
    private LocalDateTime loginDate;

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
