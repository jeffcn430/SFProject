package com.sf.manage.utils;

import com.sf.manage.enums.ResultStatus;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class LayTableReturn extends JsonResult {
    private long count;


    public LayTableReturn(Page page) {
        super(ResultStatus.SUCCESS.getCode(), ResultStatus.SUCCESS.getMsg(), page.getContent());
        this.count = page.getTotalElements();
    }
}
