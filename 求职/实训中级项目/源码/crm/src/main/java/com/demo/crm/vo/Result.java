package com.demo.crm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public Result addList(Object value) {
        data.put("list", value);
        return this;
    }

    public Result addTotal(Object value) {
        data.put("total", value);
        return this;
    }

    public Result addToken(Object value) {
        data.put("token", value);
        return this;
    }

    // 返回 不携带数据
    public static Result ok() {
        Result result = new Result();
        result.setCode(200); // http status code 200
        result.setMessage("OK");
        return result;
    }

    // 返回 401
    public static Result error401() {
        Result result = new Result();
        result.setCode(401);
        result.setMessage("Token错误");
        return result;
    }

    // 返回 500
    public static Result error500(String message) {
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        return result;
    }

}
