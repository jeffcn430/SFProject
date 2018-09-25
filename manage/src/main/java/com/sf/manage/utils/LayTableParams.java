package com.sf.manage.utils;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.thymeleaf.util.StringUtils;


@Data
public class LayTableParams {
    private int page = 1;
    private int limit = 10;
    private String field;
    private String order;

    /**
     * 将layui的table参数转换为
     *
     * @return
     */
    public Pageable getPageable() {
        Sort sort = null;
        if (!StringUtils.isEmpty(field) && !StringUtils.isEmpty(order)) {
            if (order.equals("asc")) {
                sort = new Sort(Sort.Direction.ASC, field);
            } else {
                sort = new Sort(Sort.Direction.DESC, field);
            }
        }

        Pageable pageable = null;
        if (sort == null) {
            pageable = PageRequest.of(page, limit);
        } else {
            pageable = PageRequest.of(page, limit, sort);
        }

        return pageable;
    }

    public Pageable getPageableAndSort() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return PageRequest.of(page - 1, limit, sort);
    }
}
