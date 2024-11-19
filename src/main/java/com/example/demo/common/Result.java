package com.example.demo.common;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String message;
    private Long total;
    private Object data;

    public static Result fail(){
        return result(2000,"失败",0L,null);
    }

    public static Result fail(String message){
        return result(2000,message,0L,null);
    }

    public static Result suc(){
        return result(1000,"成功",0L,null);
    }

    public static Result suc(Object data){
        return result(1000,"成功",0L,data);
    }

    public static Result suc(Object data,Long total){
        return result(1000,"成功",total,data);
    }

    private static Result result(int code,String message,Long total,Object data){
        Result res=new Result();
        res.setCode(code);
        res.setMessage(message);
        res.setTotal(total);
        res.setData(data);
        return res;
    }
}