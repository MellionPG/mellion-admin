package com.mellion.admin.base.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基础entity实体类
 *
 * @author MellionPG
 * @date 2023/2/27 11:05
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建者", hidden = true)
    @TableField(fill = FieldFill.INSERT, updateStrategy = FieldStrategy.NEVER)
    @Null
    private String creator;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    @TableField(updateStrategy = FieldStrategy.NEVER)
    @Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 更新者
     */
    @ApiModelProperty(value = "更新者", hidden = true)
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @Null
    private String updater;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    @TableField(updateStrategy = FieldStrategy.NEVER)
    @Null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除标志（'1'已删除 '0'未删除）
     */
    @ApiModelProperty(value = "逻辑删除标志", hidden = true)
    @TableLogic
    @TableField(updateStrategy = FieldStrategy.NEVER)
    @Null
    private Integer deleted;

}
