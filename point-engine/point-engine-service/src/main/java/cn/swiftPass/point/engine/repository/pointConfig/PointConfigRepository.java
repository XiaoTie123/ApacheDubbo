package cn.swiftPass.point.engine.repository.pointConfig;

import cn.swiftPass.point.engine.entity.PointConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PointConfigRepository extends JpaRepository<PointConfig, Long>, PointConfigCustomRepository, JpaSpecificationExecutor<PointConfig> {
    // Custom query methods can be added here if needed

}
