package com.mellion.admin.base.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 分页请求参数
 *
 * @author MellionPG
 * @date 2023/2/27 12:01
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页参数")
public class PageParam implements Serializable {

    /**
     * 页码默认值
     */
    private static final Integer CURRENT_PAGE = 1;

    /**
     * 页的大小默认值
     */
    private static final Integer PAGE_SIZE = 10;

    /**
     * 当前页码
     */
    @ApiModelProperty("当前页码")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页码最小值为1")
    private Integer currentPage = CURRENT_PAGE;

    /**
     * 页的大小
     */
    @ApiModelProperty("页的大小")
    @NotNull(message = "每页条数不能为空")
    @Min(value = 1, message = "页的大小最小值为1")
    @Max(value = 100, message = "每页条数最大值为100")
    private Integer pageSize = PAGE_SIZE;

}
