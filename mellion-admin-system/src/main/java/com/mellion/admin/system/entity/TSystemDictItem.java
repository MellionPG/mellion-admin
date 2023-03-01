package com.mellion.admin.system.entity;

import com.mellion.admin.base.pojo.BaseEntity;
import com.mellion.admin.system.annotation.DictDefineProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 系统字典项实体类
 *
 * @author MellionPG
 * @date 2023/2/28 11:51
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("系统字典项")
public class TSystemDictItem extends BaseEntity {

    /**
     * 父级字典项ID
     */
    @ApiModelProperty("父级字典项ID")
    private Long parentId;

    /**
     * 字典定义ID
     */
    @ApiModelProperty("字典定义ID")
    @NotNull
    private Long defineId;

    /**
     * 字典项键值
     */
    @ApiModelProperty("字典项键值")
    @NotBlank(message = "字典项键值不能空缺或为空串")
    @Size(max = 32, message = "字典项键值长度不能超过32位")
    private String value;

    /**
     * 字典项文本
     */
    @ApiModelProperty("字典项文本")
    @NotBlank(message = "字典项文本不能空缺或为空串")
    @Size(max = 128, message = "字典项文本长度不能超过128位")
    private String text;

    /**
     * 颜色类型(枚举)
     */
    @ApiModelProperty("颜色类型(枚举)")
    @DictDefineProperty(dictCode = "color_type")
    private Integer colorType;

    /**
     * 状态(1正常 0停用)
     */
    @ApiModelProperty("状态(1正常 0停用)")
    @DictDefineProperty(dictCode = "status")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
