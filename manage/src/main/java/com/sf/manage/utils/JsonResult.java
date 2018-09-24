package com.sf.manage.utils;

import com.sf.manage.enums.ResultStatus;
import javafx.print.PageLayout;
import lombok.Data;

import java.awt.print.Pageable;

@Data
public class JsonResult {
    private int code;
    private String msg;
    private Object data;

    public JsonResult() {
        this.code = ResultStatus.SUCCESS.getCode();
        this.msg = ResultStatus.SUCCESS.getMsg();
    }

    public JsonResult(ResultStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public JsonResult(ResultStatus status, String msg) {
        this.code = status.getCode();
        this.msg = msg;
    }

    public JsonResult(ResultStatus status, Object data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }

    public JsonResult(int status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.code = ResultStatus.SUCCESS.getCode();
        this.msg = ResultStatus.SUCCESS.getMsg();
        this.data = data;
    }
}
