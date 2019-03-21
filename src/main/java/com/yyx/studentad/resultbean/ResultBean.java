package com.yyx.studentad.resultbean;


import org.springframework.stereotype.Component;

/**
 * 阿桑
 * 2019/3/13
 */
@Component
public class ResultBean {
    private String msg;
    private Integer code;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResultBean() {
    }

    public ResultBean(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }
}
