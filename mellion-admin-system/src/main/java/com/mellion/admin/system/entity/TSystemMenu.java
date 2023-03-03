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
import javax.validation.constraints.Size;

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
    @NotNull(message = "菜单名称不能为空")
    @Size(max = 64, message = "菜单名称长度不能超过64位")
    private String name;

    /**
     * 菜单类型(枚举)
     */
    @ApiModelProperty("菜单类型(枚举)")
    @DictDefineProperty(dictCode = "menu_type")
    @NotNull(message = "菜单类型不能为空")
    private Integer menuType;

    /**
     * 组件路径
     */
    @ApiModelProperty("组件路径")
    @Size(max = 256, message = "组件路径的长度不能超过256位")
    private String componentUrl;

    /**
     * 请求路径
     */
    @ApiModelProperty("请求路径")
    @Size(max = 256, message = "请求路径的长度不能超过256位")
    private String requestUrl;

    /**
     * 请求方法
     */
    @ApiModelProperty("请求方法")
    @DictDefineProperty(dictCode = "request_method")
    private Integer requestMethod;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
    @NotNull(message = "显示顺序不能为空")
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
    @DictDefineProperty(dictCode = "visible")
    @NotNull(message = "是否可见不能为空")
    private Integer visible;

    /**
     * 是否缓存(枚举)
     */
    @ApiModelProperty("是否缓存(枚举)")
    @DictDefineProperty(dictCode = "keep_alive")
    @NotNull(message = "是否缓存不能为空")
    private Integer keepAlive;

    /**
     * 是否总是显示(枚举)
     */
    @ApiModelProperty("是否总是显示(枚举)")
    @DictDefineProperty(dictCode = "always_show")
    @NotNull(message = "是否总是可见不能为空")
    private Integer alwaysShow;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    @DictDefineProperty(dictCode = "status")
    @NotNull(message = "状态不能为空")
    private Integer status;

}
