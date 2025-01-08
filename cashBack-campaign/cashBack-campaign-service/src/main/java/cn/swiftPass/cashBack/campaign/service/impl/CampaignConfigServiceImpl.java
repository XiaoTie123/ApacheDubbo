package cn.swiftPass.cashBack.campaign.service.impl;

import cn.swiftPass.cashBack.campaign.common.enums.CommonStatus;
import cn.swiftPass.cashBack.campaign.common.util.CommonConstants;
import cn.swiftPass.cashBack.campaign.common.util.CommonUtil;
import cn.swiftPass.cashBack.campaign.dto.campaignConfig.CampaignConfigDto;
import cn.swiftPass.cashBack.campaign.entity.CampaignConfig;
import cn.swiftPass.cashBack.campaign.repository.campaignConfig.CampaignConfigRepository;
import cn.swiftPass.cashBack.campaign.request.campaignConfig.CampaignConfigRequest;
import cn.swiftPass.cashBack.campaign.request.campaignConfig.CampaignConfigSearchRequest;
import cn.swiftPass.cashBack.campaign.service.CampaignConfigService;
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
public class CampaignConfigServiceImpl implements CampaignConfigService {

    @Autowired
    private CampaignConfigRepository campaignConfigRepository;

    @Override
    @Transactional
    public void create(CampaignConfigRequest request) {
        CampaignConfig entity = new CampaignConfig();
        entity.setCreatedTime(new Date());
        convertEntity(entity, request);
        campaignConfigRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(CampaignConfigRequest request) {
        Optional<CampaignConfig> existingEntity = campaignConfigRepository.findById(request.getId());
        if (existingEntity.isPresent()) {
            CampaignConfig entity = existingEntity.get();
            entity.setUpdatedTime(new Date());
            convertEntity(entity, request);
            campaignConfigRepository.save(entity);
        } else {
            throw new IllegalArgumentException("PointConfig with id " + request.getId() + " not found.");
        }
    }

    private void convertEntity(CampaignConfig entity, CampaignConfigRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStatus(CommonStatus.ACTIVE.getCode());
        entity.setDelFlg(0);
    }

    @Override
    public CampaignConfigDto getDataById(long configId) {
        Optional<CampaignConfig> campaignConfigOpt = campaignConfigRepository.findById(configId);
        if (campaignConfigOpt.isPresent()) {
            CampaignConfig campaignConfig = campaignConfigOpt.get();
            return convertToDto(campaignConfig);  // Convert the entity to DTO
        } else {
            throw new EntityNotFoundException("CampaignConfig not found for id: " + configId);
        }
    }

    @Override
    public List<CampaignConfigDto> getDataList(CampaignConfigSearchRequest searchData) {
        List<CampaignConfig> pointConfigList = campaignConfigRepository.findAll();
        return pointConfigList.stream()
                .filter(pointConfig -> pointConfig.getDelFlg() == 0)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CampaignConfigDto convertToDto(CampaignConfig campaignConfig) {
        CampaignConfigDto dto = new CampaignConfigDto();
        dto.setId(campaignConfig.getId());
        dto.setName(campaignConfig.getName());
        dto.setDescription(campaignConfig.getDescription());
        if(CommonUtil.validInteger(campaignConfig.getStatus())) {
            dto.setStatusDesc(CommonStatus.getDescriptionByCode(campaignConfig.getStatus()));
        }
        dto.setCreatedTimeStr(CommonUtil.dateToString(CommonConstants.STD_DATE_FORMAT, campaignConfig.getCreatedTime()));
        return dto;
    }

    @Override
    public boolean updateDeleteFlag(long pointConfigId) {
        return campaignConfigRepository.updateDeleteFlag(pointConfigId);
    }


}
