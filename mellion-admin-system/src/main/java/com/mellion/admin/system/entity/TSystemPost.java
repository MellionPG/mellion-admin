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
 * 系统岗位实体类
 *
 * @author MellionPG
 * @date 2023/3/2 15:38
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统岗位")
public class TSystemPost extends BaseEntity {

    /**
     * 岗位编码
     */
    @ApiModelProperty("岗位编码")
    @NotNull(message = "岗位编码不能为空")
    @Size(max = 64, message = "岗位编码长度不能超过64位")
    private String code;

    /**
     * 岗位名称
     */
    @ApiModelProperty("岗位名称")
    @NotNull(message = "岗位名称不能为空")
    @Size(max = 32, message = "岗位名称长度不能超过32位")
    private String name;

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
