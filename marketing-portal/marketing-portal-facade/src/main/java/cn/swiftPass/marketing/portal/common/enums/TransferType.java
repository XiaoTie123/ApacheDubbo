package cn.swiftPass.marketing.portal.common.enums;

import cn.swiftPass.marketing.portal.common.util.CommonObject;
import cn.swiftPass.marketing.portal.common.util.CommonUtil;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum TransferType {
    W2M(1, "Wallet To Merchant"), W2W(2, "Wallet TO Wallet");

    private int code;
    private String desc;

    private TransferType(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescriptionByCode(Integer code) {

        if (!CommonUtil.validInteger(code)) {
            return "";
        }

        for (TransferType s : values()) {
            if (s.getCode() == code) {
                return s.getDesc();
            }
        }

        return "";

    }


    public static List<CommonObject> getAll() {
        return Stream.of(values()).map(s -> new CommonObject(s.getCode(), s.getDesc())).collect(Collectors.toList());
    }
}
