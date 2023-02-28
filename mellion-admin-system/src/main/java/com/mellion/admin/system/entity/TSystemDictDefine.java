package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 系统字典定义实体类
 *
 * @author MellionPG
 * @date 2023/2/28 11:07
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统字典定义")
public class TSystemDictDefine extends BaseEntity {

    /**
     * 字典编码
     */
    @ApiModelProperty("字典编码")
    @NotBlank(message = "字典编码不能空缺或为空串")
    @Size(max = 64, message = "字典编码长度不能超过64位")
    private String code;

    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    @NotBlank(message = "字典名称不能空缺或为空串")
    @Size(max = 64, message = "字典名称长度不能超过64位")
    private String name;

    /**
     * 状态(1正常 0停用)
     */
    @ApiModelProperty("状态(1正常 0停用)")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
