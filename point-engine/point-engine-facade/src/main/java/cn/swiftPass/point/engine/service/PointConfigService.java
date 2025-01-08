package cn.swiftPass.point.engine.service;


import cn.swiftPass.point.engine.dto.pointConfig.PointConfigDto;
import cn.swiftPass.point.engine.request.pointConfig.PointConfigRequest;
import cn.swiftPass.point.engine.request.pointConfig.PointConfigSearchRequest;

import java.util.List;

public interface PointConfigService {
    void create(PointConfigRequest request);

    void update(PointConfigRequest request);

    PointConfigDto getDataById(long pointConfigId);

    List<PointConfigDto> getDataList(PointConfigSearchRequest searchData);

    boolean updateDeleteFlag(long pointConfigId);

}
