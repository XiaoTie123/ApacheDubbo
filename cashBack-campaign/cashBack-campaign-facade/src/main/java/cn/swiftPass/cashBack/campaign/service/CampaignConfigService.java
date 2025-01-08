package cn.swiftPass.cashBack.campaign.service;


import cn.swiftPass.cashBack.campaign.dto.campaignConfig.CampaignConfigDto;
import cn.swiftPass.cashBack.campaign.request.campaignConfig.CampaignConfigRequest;
import cn.swiftPass.cashBack.campaign.request.campaignConfig.CampaignConfigSearchRequest;

import java.util.List;

public interface CampaignConfigService {

    void create(CampaignConfigRequest request);

    void update(CampaignConfigRequest request);

    CampaignConfigDto getDataById(long pointConfigId);

    List<CampaignConfigDto> getDataList(CampaignConfigSearchRequest searchData);

    boolean updateDeleteFlag(long pointConfigId);

}
