package com.mellion.admin.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用户权限信息VO
 *
 * @author MellionPG
 * @date 2023/3/7 15:53
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户权限信息")
public class UserPermissionInfoVO implements Serializable {

    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String username;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickname;

    /**
     * 头像地址
     */
    @ApiModelProperty("头像地址")
    private String avatar;

    /**
     * 组件url列表
     */
    @ApiModelProperty("组件url列表")
    private List<String> componentUrlList;

}
