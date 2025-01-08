package cn.swiftPass.point.engine.request.pointConfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class PointConfigRequest implements Serializable {
    private Long id;
    private String name;
    private String description;
    private Integer transferType;
    private Double transferAmount;
    private Double point;
    private Double percentage;
}
