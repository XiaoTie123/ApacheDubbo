package cn.swiftPass.wallet.response;

import java.io.Serializable;

public class ResponseModel implements Serializable {
    private String code;

    private String msg;

    private Object data;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public Object getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseModel(){
    }

    public ResponseModel(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static ResponseModel ok(String code, String msg) {
        return new ResponseModel(code, msg);
    }

    public static ResponseModel error(String code, String msg) {
        return new ResponseModel(code, msg);
    }
}
