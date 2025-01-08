package cn.swiftPass.point.engine.controller;

import cn.swiftPass.cashBack.campaign.dto.campaignConfig.CampaignConfigDto;
import cn.swiftPass.cashBack.campaign.request.campaignConfig.CampaignConfigSearchRequest;
import cn.swiftPass.cashBack.campaign.service.CampaignConfigService;
import cn.swiftPass.point.engine.common.enums.CommonEnum;
import cn.swiftPass.point.engine.response.ResponseModel;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/cashBack")
public class CashBackController {

    @DubboReference
    CampaignConfigService campaignConfigService;


    @RequestMapping(value = "/getDataById", method = RequestMethod.GET)
    public ResponseModel getDataById(@RequestParam("id") long cashBackId) {
        try {
            ResponseModel responseModel = new ResponseModel();
            CampaignConfigDto responseData = campaignConfigService.getDataById(cashBackId);
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

    @RequestMapping(value = "/getDataList", method = RequestMethod.POST)
    public ResponseModel getDataList(@RequestBody CampaignConfigSearchRequest searchData) {
        try {
            ResponseModel responseModel = new ResponseModel();
            List<CampaignConfigDto> responseData = campaignConfigService.getDataList(searchData);
            if(responseData != null) {
                responseModel.setCode(CommonEnum.CODE_000005.getCode());
                responseModel.setMsg(CommonEnum.CODE_000005.getDesc());
                responseModel.setData(responseData);
            }
            return responseModel;
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseModel delete(@RequestParam("id") long pointConfigId) {
        try {
            boolean checkDelete = campaignConfigService.updateDeleteFlag(pointConfigId);
            if(checkDelete)
                return ResponseModel.ok(CommonEnum.CODE_000003.getCode(), CommonEnum.CODE_000003.getDesc());
            else
                return ResponseModel.error(CommonEnum.ERRORCODE_100001.getCode(), CommonEnum.ERRORCODE_100001.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }
}
