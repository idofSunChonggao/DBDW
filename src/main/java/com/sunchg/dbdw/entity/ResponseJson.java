package com.sunchg.dbdw.entity;

import com.sunchg.dbdw.pub.ResponseCodeEnums;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author SunChonggao
 * @Date 2020-09-09 22:04
 * @Version 1.0
 * @Description：统一接口返回JSON数据的格式
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public final class ResponseJson<T> implements Serializable {
    private Boolean success;
    private String code;
    private String msg;
    private T data;

    public ResponseJson(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResponseJson(Boolean success, String errCode, String errMsg) {
        this.success = success;
        this.code = errCode;
        this.msg = errMsg;
    }

    public ResponseJson(Boolean success, ResponseCodeEnums enums) {
        this.success = success;
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public ResponseJson(Boolean success, T data, ResponseCodeEnums enums) {
        this.success = success;
        this.data = data;
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }
}