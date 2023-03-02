package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 系统菜单实体类
 *
 * @author MellionPG
 * @date 2023/3/2 15:21
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统菜单")
public class TSystemMenu extends BaseEntity {

    /**
     * 父级菜单ID
     */
    @ApiModelProperty("父级菜单ID")
    private Long parentId;

    /**
     * 菜单名称
     */
    @ApiModelProperty("菜单名称")
    private String name;

    /**
     * 菜单类型(枚举)
     */
    @ApiModelProperty("菜单类型(枚举)")
    private Integer menuType;

    /**
     * 请求路径
     */
    @ApiModelProperty("请求路径")
    private String requestUrl;

    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    private String requestMethod;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    private Integer sortNumber;

    /**
     * 菜单图标
     */
    @ApiModelProperty("菜单图标")
    private String icon;

    /**
     * 是否可见(枚举)
     */
    @ApiModelProperty("是否可见(枚举)")
    private Integer visible;

    /**
     * 是否缓存(枚举)
     */
    @ApiModelProperty("是否缓存(枚举)")
    private Integer keepAlive;

    /**
     * 是否总是显示(枚举)
     */
    @ApiModelProperty("是否总是显示(枚举)")
    private Integer alwaysShow;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    private Integer status;

}
