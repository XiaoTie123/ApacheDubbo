package cn.swiftPass.cashBack.campaign.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class ResponseModel implements Serializable {
    private String code;

    private String msg;

    private Object data;

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
