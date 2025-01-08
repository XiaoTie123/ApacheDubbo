package cn.swiftPass.point.engine.repository.pointConfig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

public class PointConfigCustomRepositoryImpl implements PointConfigCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public boolean updateDeleteFlag(long pointConfigId) {
        String query = "UPDATE PointConfig p SET p.delFlg = 1 WHERE p.id = :pointConfigId AND p.delFlg != 1";
        int updatedRows = entityManager.createQuery(query)
                .setParameter("pointConfigId", pointConfigId)
                .executeUpdate();
        return updatedRows > 0;
    }
}
