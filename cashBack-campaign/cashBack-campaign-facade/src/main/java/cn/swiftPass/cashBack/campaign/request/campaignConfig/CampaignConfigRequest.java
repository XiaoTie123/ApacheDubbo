package cn.swiftPass.cashBack.campaign.request.campaignConfig;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES)
public class CampaignConfigRequest implements Serializable {
    private Long id;
    private String name;
    private String description;
}
