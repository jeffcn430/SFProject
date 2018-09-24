package com.sf.manage.utils;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.thymeleaf.util.StringUtils;

import java.time.LocalDate;


@Data
public class LayTableParams {
    private int page;
    private int limit;
    private String field;
    private String order;

    LocalDate startTime;
    LocalDate endTime;

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
            pageable = PageRequest.of(page - 1, limit);
        } else {
            pageable = PageRequest.of(page - 1, limit, sort);
        }

        return pageable;
    }

    public Pageable getPageableAndSort() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        return PageRequest.of(page - 1, limit, sort);
    }
}
