package cn.swiftPass.cashBack.campaign.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "campaign_config")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampaignConfig extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private Integer status;

    @Column(name = "del_flg")
    private Integer delFlg;
}
