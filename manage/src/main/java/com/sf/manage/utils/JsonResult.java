package com.sf.manage.utils;

import com.sf.manage.enums.ResultStatus;
import lombok.Data;

@Data
public class JsonResult {
    private int status;
    private String msg;
    private Object data;

    public JsonResult() {
        this.status = ResultStatus.SUCCESS.getCode();
        this.msg = ResultStatus.SUCCESS.getMsg();
    }

    public JsonResult(ResultStatus status) {
        this.status = status.getCode();
        this.msg = status.getMsg();
    }

    public JsonResult(ResultStatus status, String msg) {
        this.status = status.getCode();
        this.msg = msg;
    }

    public JsonResult(ResultStatus status, Object data) {
        this.status = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
    }

    public JsonResult(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.status = ResultStatus.SUCCESS.getCode();
        this.msg = ResultStatus.SUCCESS.getMsg();
        this.data = data;
    }
}
