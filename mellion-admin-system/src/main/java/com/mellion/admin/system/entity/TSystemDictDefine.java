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
    @NotNull(message = "字典编码不能空")
    @Size(max = 64, message = "字典编码长度不能超过64位")
    private String code;

    /**
     * 字典名称
     */
    @ApiModelProperty("字典名称")
    @NotNull(message = "字典名称不能空")
    @Size(max = 64, message = "字典名称长度不能超过64位")
    private String name;

    /**
     * 状态(枚举)
     */
    @ApiModelProperty("状态(枚举)")
    @DictDefineProperty(dictCode = "status")
    @NotNull(message = "状态不能为空")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Size(max = 256, message = "备注信息不能超过256位")
    private String remark;

}
