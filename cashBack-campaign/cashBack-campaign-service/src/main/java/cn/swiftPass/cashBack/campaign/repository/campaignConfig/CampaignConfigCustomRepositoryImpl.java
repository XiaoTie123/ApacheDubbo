package cn.swiftPass.cashBack.campaign.repository.campaignConfig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class CampaignConfigCustomRepositoryImpl implements CampaignConfigCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean updateDeleteFlag(long pointConfigId) {
        String query = "UPDATE CampaignConfig p SET p.delFlg = 1 WHERE p.id = :pointConfigId AND p.delFlg != 1";
        int updatedRows = entityManager.createQuery(query)
                .setParameter("pointConfigId", pointConfigId)
                .executeUpdate();
        return updatedRows > 0;
    }
}
