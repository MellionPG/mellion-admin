package com.mellion.admin.system.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * 封装登录提交过来的表单数据
 *
 * @author MellionPG
 * @date 2023/3/6 15:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("登录表单请求参数")
public class LoginFormRequestParam implements Serializable {

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
    @NotNull
    @Pattern(regexp = "^(?=.*[a-zA-Z0-9].*)(?=.*[a-zA-Z.!@#$%^&*].*)(?=.*[0-9.!@#$%^&*].*).{6,32}$",
            message = "密码长度必须为6-32位，并且包含数字、字母、特殊符号中的至少两种")
    private String password;

    /**
     * 保持登录状态
     */
    @ApiModelProperty("保持登录状态")
    @NotNull
    private Boolean saveLoginStatus;

}
