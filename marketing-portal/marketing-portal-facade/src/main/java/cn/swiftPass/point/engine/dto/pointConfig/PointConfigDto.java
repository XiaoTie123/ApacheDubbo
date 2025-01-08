package cn.swiftPass.point.engine.dto.pointConfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class PointConfigDto implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer transferType;
    private String transferTypeDesc;
    private Double transferAmount;
    private Double point;
    private Double percentage;
    private Integer status;
    private String statusDesc;
    private Integer delFlg;
    private Date createdTime;
    private String createdTimeStr;
    private Date updatedTime;
    private String updatedTimeStr;
}
