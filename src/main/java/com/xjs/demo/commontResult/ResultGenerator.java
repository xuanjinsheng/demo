package com.xjs.demo.commontResult;

public class ResultGenerator {

    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

//    public static Result genSuccessResult(){
//        return new Result().setCodeEnum(ResultCodeEnum.SUCCESS)
//                .setMessage(DEFAULT_SUCCESS_MESSAGE);
//    }

    public static <E> Result<E> genSuccessResult(E data){
        return new Result().setCodeEnum(ResultCodeEnum.SUCCESS).setCodeEnum(ResultCodeEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message){
        return new Result().setCodeEnum(ResultCodeEnum.FAIL)
                .setMessage(message);
    }
    public static Result genUnauthorizedResult() {
        return new Result()
                .setCodeEnum(ResultCodeEnum.UNAUTHORIZED)
                .setMessage("权限不足！");
    }
}
