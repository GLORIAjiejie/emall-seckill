/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Result
 * Author:   min
 * Date:     2020-08-02 14:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.cwu.emallseckill.result;

import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.util.ObjectUtils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author min
 * @create 2020-08-02
 * @since 1.0.0
 */
public class Result<T> {
    private int code;
    private String msg;
    private T data;

    public Result(T data) {
        this.code=CodeMsg.SUCEESS.getCode();
        this.msg= CodeMsg.SUCEESS.getMsg();
        this.data = data;
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(CodeMsg codeMsg){
        if (!ObjectUtils.isEmpty(codeMsg)){
            this.code=codeMsg.getCode();
            this.msg=codeMsg.getMsg();
        }
    }
    /**
     * 是否成功
     * */
    public boolean isSuccess(){
        return this.code==CodeMsg.SUCEESS.getCode();
    }
    /**
     *成功返回的消息及数据
     * */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }
    /**
     *失败返回的消息及数据
     * */
    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<>(codeMsg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
