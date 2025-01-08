package cn.swiftPass.cashBack.campaign.common.enums;

public enum CommonEnum {
    CODE_000001("000001", "Saved Successfully"),
    CODE_000002("000002", "Updated Successfully"),
    CODE_000003("000003", "Deleted Successfully"),
    CODE_000004("000004", "Get Data"),
    CODE_000005("000005", "Get Data List"),

    CODE_000006("000006", "Code Already Exist"),
    CODE_000007("000007", "Name Already Exist"),
    ERRORCODE_019999("019999", "System internal abnormal"),
    ERRORCODE_100001("100001", "Delete Is Not Successfully");

    private String code;

    private String desc;

    private CommonEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
