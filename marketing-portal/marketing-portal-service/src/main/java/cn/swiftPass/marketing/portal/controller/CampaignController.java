package cn.swiftPass.marketing.portal.controller;

import cn.swiftPass.marketing.portal.common.enums.CommonEnum;
import cn.swiftPass.marketing.portal.response.ResponseModel;
import cn.swiftPass.point.engine.dto.pointConfig.PointConfigDto;
import cn.swiftPass.point.engine.service.PointConfigService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/marketingPortal")
public class CampaignController {

    @DubboReference
    private PointConfigService pointConfigService;

    @RequestMapping(value = "/getDataById", method = RequestMethod.GET)
    public ResponseModel getDataById(@RequestParam("id") long pointConfigId) {
        try {
            ResponseModel responseModel = new ResponseModel();
            PointConfigDto responseData = pointConfigService.getDataById(pointConfigId);
            if(responseData != null) {
                responseModel.setCode(CommonEnum.CODE_000004.getCode());
                responseModel.setMsg(CommonEnum.CODE_000004.getDesc());
                responseModel.setData(responseData);
            }
            return responseModel;
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

}
