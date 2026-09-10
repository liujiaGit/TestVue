package com.example.testvue.untils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Result<T> {

    //返回信息码
    private String code;
    //返回信息
    private String msg;
    //返回数据
    T data;

    public Result(){}

    public Result(T data){
        this.data=data;
    }


    //成功，只返回成功码和信息
    public static <T> Result<T> ok(){
        Result<T> result=new Result<>();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        return result;
    }

    //成功，返回成功码、信息和数据
    public static <T> Result<T> success(T data){
        Result<T> result=new Result();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);
        result.setData(data);
        return result;
    }

    //失败，返回自己定义的信息码和信息
    public static <T> Result<T> error(){
        Result<T> result=new Result<>();
        result.setCode(ResultCode.ERROR.code);
        result.setMsg(ResultCode.ERROR.msg);
        return result;
    }

    //失败，返回controller层传过来信息码和信息
    public static <T> Result<T> error(String code,String msg){
        Result<T> result=new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
