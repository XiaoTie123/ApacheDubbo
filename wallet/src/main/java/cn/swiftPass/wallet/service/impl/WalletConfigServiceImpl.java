package cn.swiftPass.wallet.service.impl;


import cn.swiftPass.wallet.common.enums.CommonStatus;
import cn.swiftPass.wallet.common.util.CommonConstants;
import cn.swiftPass.wallet.common.util.CommonUtil;
import cn.swiftPass.wallet.dto.walletConfig.WalletConfigDto;
import cn.swiftPass.wallet.entity.WalletConfig;
import cn.swiftPass.wallet.repository.walletConfig.WalletConfigRepository;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigRequest;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigSearchRequest;
import cn.swiftPass.wallet.service.WalletConfigService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@DubboService
public class WalletConfigServiceImpl implements WalletConfigService {

    @Autowired
    private WalletConfigRepository walletConfigRepository;

    @Override
    @Transactional
    public void create(WalletConfigRequest request) {
        WalletConfig entity = new WalletConfig();
        entity.setCreatedTime(new Date());
        convertEntity(entity, request);
        walletConfigRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(WalletConfigRequest request) {
        Optional<WalletConfig> existingEntity = walletConfigRepository.findById(request.getId());
        if (existingEntity.isPresent()) {
            WalletConfig entity = existingEntity.get();
            entity.setUpdatedTime(new Date());
            convertEntity(entity, request);
            walletConfigRepository.save(entity);
        } else {
            throw new IllegalArgumentException("PointConfig with id " + request.getId() + " not found.");
        }
    }

    private void convertEntity(WalletConfig entity, WalletConfigRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus(CommonStatus.ACTIVE.getCode());
        entity.setDelFlg(0);
    }

    @Override
    public WalletConfigDto getDataById(long configId) {
        Optional<WalletConfig> campaignConfigOpt = walletConfigRepository.findById(configId);
        if (campaignConfigOpt.isPresent()) {
            WalletConfig campaignConfig = campaignConfigOpt.get();
            return convertToDto(campaignConfig);  // Convert the entity to DTO
        } else {
            throw new EntityNotFoundException("CampaignConfig not found for id: " + configId);
        }
    }

    @Override
    public List<WalletConfigDto> getDataList(WalletConfigSearchRequest searchData) {
        List<WalletConfig> walletConfigList = walletConfigRepository.findAll();
        return walletConfigList.stream()
                .filter(walletConfig -> walletConfig.getDelFlg() == 0)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private WalletConfigDto convertToDto(WalletConfig walletConfig) {
        WalletConfigDto dto = new WalletConfigDto();
        dto.setId(walletConfig.getId());
        dto.setName(walletConfig.getName());
        dto.setDescription(walletConfig.getDescription());
        if(CommonUtil.validInteger(walletConfig.getStatus())) {
            dto.setStatusDesc(CommonStatus.getDescriptionByCode(walletConfig.getStatus()));
        }
        dto.setCreatedTimeStr(CommonUtil.dateToString(CommonConstants.STD_DATE_FORMAT, walletConfig.getCreatedTime()));
        return dto;
    }

    @Override
    public boolean updateDeleteFlag(long walletConfigId) {
        return walletConfigRepository.updateDeleteFlag(walletConfigId);
    }


}
