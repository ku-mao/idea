package edu.springboot.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ResponseResult {
    private boolean success; //
    private Object data; //success = true 需要的业务数据

    private String code;//success = false 需要的错误码
    private  String message;//错误信息

}
