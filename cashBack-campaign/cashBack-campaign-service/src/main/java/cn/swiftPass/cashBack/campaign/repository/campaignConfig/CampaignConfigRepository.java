package cn.swiftPass.cashBack.campaign.repository.campaignConfig;

import cn.swiftPass.cashBack.campaign.entity.CampaignConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignConfigRepository extends JpaRepository<CampaignConfig, Long>, CampaignConfigCustomRepository, JpaSpecificationExecutor<CampaignConfig> {
    // Custom query methods can be added here if needed

}
