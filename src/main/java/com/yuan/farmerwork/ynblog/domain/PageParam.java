package com.yuan.farmerwork.ynblog.domain;
import com.github.pagehelper.IPage;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * 基础分页实体.
 *
 * @author : YJS
 * @date: 2020-10-27 14:47
 */
@Data
@Accessors(chain = true)
public class PageParam<T>  implements IPage {

    /*
     * description = "页码", defaultValue =  1
     */
    private Integer pageNum = 1;

    /*
     *description = "页数", defaultValue = 20
     */
    private Integer pageSize = 2;

    /*
     * description = "排序", example = "id desc"
     */
    private String orderBy;

    /*
     *description = "参数"
     */
    private T param;

    public PageParam<T> setOrderBy(String orderBy) {
        // 此处可优化 优化详情且看解析
        this.orderBy = orderBy;
        return this;
    }
}