package cn.swiftPass.wallet.service;


import cn.swiftPass.wallet.dto.walletConfig.WalletConfigDto;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigRequest;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigSearchRequest;

import java.util.List;

public interface WalletConfigService {

    void create(WalletConfigRequest request);

    void update(WalletConfigRequest request);

    WalletConfigDto getDataById(long pointConfigId);

    List<WalletConfigDto> getDataList(WalletConfigSearchRequest searchData);

    boolean updateDeleteFlag(long pointConfigId);

}
