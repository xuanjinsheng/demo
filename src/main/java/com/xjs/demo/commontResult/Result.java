package com.xjs.demo.commontResult;

public class Result<E> {

    private ResultCodeEnum codeEnum;

    private String message;

    private E data;

    public ResultCodeEnum getCodeEnum(){
        return codeEnum;
    }

    public Result(){
    }

    public Result setCodeEnum(ResultCodeEnum resultCodeEnum){
        this.codeEnum = resultCodeEnum;
        return this;
    }

    public String getMessage(){
        return message;
    }

    public Result setMessage(String message){
        this.message = message;
        return this;
    }
    public E getData(){
        return  data;
    }

    public Result setData(E data){
        this.data = data;
        return  this;
    }

}
