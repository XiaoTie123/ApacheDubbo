package cn.swiftPass.point.engine.service;

import cn.swiftPass.point.engine.dto.pointConfig.PointConfigDto;

public interface PointConfigService {

    PointConfigDto getDataById(long pointConfigId);

}
