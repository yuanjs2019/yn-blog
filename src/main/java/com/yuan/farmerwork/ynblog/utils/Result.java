package com.yuan.farmerwork.ynblog.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.List;

/**
 * 自定义响应结构.
 * @author
 */
public class Result<T> implements Serializable {

    /**
     * 定义jackson对象.
     */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 响应业务状态.
     */
    private Integer code;

    /**
     * 响应消息.
     */
    private String message;

    /**
     * 响应中的数据.
     */
    private T data;

    private boolean success;

    public Result() {
    }

    public Result(Integer code, String message, boolean success, T data) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.data = data;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = true;
    }

    public Result(T data) {
        this.code = 200;
        this.message = "OK";
        this.success = true;
        this.data = data;
    }

    public static Result ok(Object data) {
        return new Result(data);
    }

    public static Result ok() {
        return new Result(null);
    }

    public static Result build(Integer code, String message, boolean success, Object data) {
        return new Result(code, message, success, data);
    }

    public static Result build(Integer code, String message, Object data) {
        return new Result(code, message, code == 200, data);
    }

    public static Result build(Integer code, String message) {
        return new Result(code, message, code == 200, null);
    }

    public static Result build(Integer code, String message, boolean success) {
        return new Result(code, message, success, null);
    }

    public static ObjectMapper getMAPPER() {
        return MAPPER;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 将json结果集转化为Result对象.
     *
     * @param jsonData json数据
     * @param clazz    Result中的object类型
     * @return
     */
    public static Result formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, Result.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化.
     *
     * @param json
     * @return
     */
    public static Result format(String json) {
        try {
            return MAPPER.readValue(json, Result.class);
        } catch (Exception e) {
            throw new BaseException(500, e.getMessage(), e);
        }
    }

    /**
     * Object是集合转化.
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static Result formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("message").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

}
