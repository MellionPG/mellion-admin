package com.mellion.admin.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户登录令牌VO
 *
 * @author MellionPG
 * @date 2023/3/7 11:08
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户登录令牌")
public class UserLoginTokenVO implements Serializable {

    /**
     * 登录令牌
     */
    @ApiModelProperty("登录令牌")
    private String token;

}
