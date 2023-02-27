package com.mellionpg.admin.server.test.entity;

import com.mellionpg.admin.base.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * 测试样例实体类
 *
 * @author MellionPG
 * @date 2023/2/27 10:48
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("测试样例")
public class TTestDemo extends BaseEntity {

    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    @NotNull
    @Max(20)
    private String name;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

}
