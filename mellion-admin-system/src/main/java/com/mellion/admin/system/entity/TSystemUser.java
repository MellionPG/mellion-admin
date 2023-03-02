package com.mellion.admin.system.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
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
    @NotNull
    @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]{3,19}$",
            message = "账号长度必须为4-20位，允许字母数字下划线，但必须字母开头")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @Pattern(regexp = "^(?=.*[a-zA-Z0-9].*)(?=.*[a-zA-Z.!@#$%^&*].*)(?=.*[0-9.!@#$%^&*].*).{6,32}$",
            message = "密码长度必须为6-32位，并且包含数字、字母、特殊符号中的至少两种")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    @Size(max = 32, message = "昵称长度不能超过32位")
    private String nickname;

    /**
     * 性别(枚举)
     */
    @ApiModelProperty("性别(枚举)")
    @DictDefineProperty(dictCode = "sex")
    private Integer sex;

    /**
     * 出生年月日
     */
    @ApiModelProperty("出生年月日")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthdate;

    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    @Pattern(regexp = "^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$",
            message = "手机号码格式有误")
    private String mobileNumber;

    /**
     * 电子邮箱
     */
    @ApiModelProperty("电子邮箱")
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",
            message = "电子邮箱格式有误")
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime loginDate;

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
