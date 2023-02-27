package com.mellionpg.admin.base.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

/**
 * 分页请求参数
 *
 * @author MellionPG
 * @date 2023/2/27 12:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageParam {

    /**
     * 当前页码
     */
    @ApiModelProperty("当前页码")
    @Min(value = 1, message = "页码最小值为1")
    private Integer currentPage = 1;

    /**
     * 页的大小
     */
    @ApiModelProperty("页的大小")
    @Min(value = 1, message = "页的大小最小值为1")
    private Integer pageSize = 10;

}
