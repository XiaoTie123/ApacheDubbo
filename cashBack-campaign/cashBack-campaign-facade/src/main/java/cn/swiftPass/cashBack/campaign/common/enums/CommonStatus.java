package cn.swiftPass.cashBack.campaign.common.enums;

import cn.swiftPass.cashBack.campaign.common.util.CommonObject;
import cn.swiftPass.cashBack.campaign.common.util.CommonUtil;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
public enum CommonStatus {
    ACTIVE(1, "Active"), INACTIVE(2, "Inactive");

    private int code;
    private String desc;

    private CommonStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static String getDescriptionByCode(Integer code) {

        if (!CommonUtil.validInteger(code)) {
            return "";
        }

        for (CommonStatus s : values()) {
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
