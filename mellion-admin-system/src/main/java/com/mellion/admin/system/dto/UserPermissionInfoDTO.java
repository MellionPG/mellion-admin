package com.mellion.admin.system.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 用户权限信息DTO
 *
 * @author MellionPG
 * @date 2023/3/7 9:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户权限信息")
public class UserPermissionInfoDTO implements Serializable {

    /**
     * 菜单关键信息
     */
    @ApiModelProperty("菜单关键信息")
    private List<String> menuMainInfoList;

}
