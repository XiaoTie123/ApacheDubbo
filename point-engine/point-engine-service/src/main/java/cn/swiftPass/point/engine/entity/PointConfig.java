package cn.swiftPass.point.engine.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "point_config")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointConfig extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "transfer_type")
    private Integer transferType;

    @Column(name = "transfer_amount")
    private Double transferAmount;

    @Column(name = "point")
    private Double point;

    @Column(name = "percentage")
    private Double percentage;

    @Column(name = "status")
    private Integer status;

    @Column(name = "del_flg")
    private Integer delFlg;
}
