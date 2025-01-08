package cn.swiftPass.point.engine.service.impl;

import cn.swiftPass.point.engine.common.enums.CommonStatus;
import cn.swiftPass.point.engine.common.enums.TransferType;
import cn.swiftPass.point.engine.common.util.CommonConstants;
import cn.swiftPass.point.engine.common.util.CommonUtil;
import cn.swiftPass.point.engine.dto.pointConfig.PointConfigDto;
import cn.swiftPass.point.engine.repository.pointConfig.PointConfigRepository;
import cn.swiftPass.point.engine.entity.PointConfig;
import cn.swiftPass.point.engine.request.pointConfig.PointConfigRequest;
import cn.swiftPass.point.engine.request.pointConfig.PointConfigSearchRequest;
import cn.swiftPass.point.engine.service.PointConfigService;
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
public class PointConfigServiceImpl implements PointConfigService {

    @Autowired
    private PointConfigRepository pointConfigRepository;

    @Override
    @Transactional
    public void create(PointConfigRequest request) {
        PointConfig entity = new PointConfig();
        entity.setCreatedTime(new Date());
        convertEntity(entity, request);
        pointConfigRepository.save(entity);
    }

    @Override
    @Transactional
    public void update(PointConfigRequest request) {
        Optional<PointConfig> existingEntity = pointConfigRepository.findById(request.getId());
        if (existingEntity.isPresent()) {
            PointConfig entity = existingEntity.get();
            entity.setUpdatedTime(new Date());
            convertEntity(entity, request);
            pointConfigRepository.save(entity);
        } else {
            throw new IllegalArgumentException("PointConfig with id " + request.getId() + " not found.");
        }
    }

    private void convertEntity(PointConfig entity, PointConfigRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setTransferType(request.getTransferType());
        entity.setTransferAmount(request.getTransferAmount());
        entity.setPoint(request.getPoint());
        entity.setPercentage(request.getPercentage());
        entity.setStatus(CommonStatus.ACTIVE.getCode());
        entity.setDelFlg(0);
    }

    @Override
    public PointConfigDto getDataById(long configId) {
        Optional<PointConfig> pointConfigOpt = pointConfigRepository.findById(configId);
        if (pointConfigOpt.isPresent()) {
            PointConfig pointConfig = pointConfigOpt.get();
            return convertToDto(pointConfig);  // Convert the entity to DTO
        } else {
            throw new EntityNotFoundException("PointConfig not found for id: " + configId);
        }
    }

    @Override
    public List<PointConfigDto> getDataList(PointConfigSearchRequest searchData) {
        List<PointConfig> pointConfigList = pointConfigRepository.findAll();
        return pointConfigList.stream()
                .filter(pointConfig -> pointConfig.getDelFlg() == 0)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PointConfigDto convertToDto(PointConfig pointConfig) {
        PointConfigDto dto = new PointConfigDto();
        dto.setId(pointConfig.getId());
        dto.setName(pointConfig.getName());
        dto.setDescription(pointConfig.getDescription());
        if (CommonUtil.validInteger(pointConfig.getTransferType())) {
            dto.setTransferTypeDesc(TransferType.getDescriptionByCode(pointConfig.getTransferType()));
        }
        dto.setTransferAmount(pointConfig.getTransferAmount());
        dto.setPoint(pointConfig.getPoint());
        dto.setPercentage(pointConfig.getPercentage());
        if(CommonUtil.validInteger(pointConfig.getStatus())) {
            dto.setStatusDesc(CommonStatus.getDescriptionByCode(pointConfig.getStatus()));
        }
        dto.setCreatedTimeStr(CommonUtil.dateToString(CommonConstants.STD_DATE_FORMAT, pointConfig.getCreatedTime()));
        return dto;
    }



    @Override
    public boolean updateDeleteFlag(long pointConfigId) {
        return pointConfigRepository.updateDeleteFlag(pointConfigId);
    }


}
