package cn.swiftPass.wallet.repository.walletConfig;

import cn.swiftPass.wallet.entity.WalletConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletConfigRepository extends JpaRepository<WalletConfig, Long>, WalletConfigCustomRepository, JpaSpecificationExecutor<WalletConfig> {
    // Custom query methods can be added here if needed

}
