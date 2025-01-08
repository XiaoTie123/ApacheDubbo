package cn.swiftPass.point.engine.controller;

import cn.swiftPass.cashBack.campaign.service.CampaignConfigService;
import cn.swiftPass.point.engine.common.enums.CommonEnum;
import cn.swiftPass.point.engine.dto.pointConfig.PointConfigDto;
import cn.swiftPass.point.engine.request.pointConfig.PointConfigRequest;
import cn.swiftPass.point.engine.request.pointConfig.PointConfigSearchRequest;
import cn.swiftPass.point.engine.response.ResponseModel;
import cn.swiftPass.point.engine.service.PointConfigService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/pointConfig")
public class PointConfigController {

    @Autowired
    PointConfigService pointConfigService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseModel create(@RequestBody PointConfigRequest requestData) {
        try {
            pointConfigService.create(requestData);
            return ResponseModel.ok(CommonEnum.CODE_000001.getCode(), CommonEnum.CODE_000001.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseModel update(@RequestBody PointConfigRequest requestData) {
        try {
            pointConfigService.update(requestData);
            return ResponseModel.ok(CommonEnum.CODE_000002.getCode(), CommonEnum.CODE_000002.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

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

    @RequestMapping(value = "/getDataList", method = RequestMethod.POST)
    public ResponseModel getDataList(@RequestBody PointConfigSearchRequest searchData) {
        try {
            ResponseModel responseModel = new ResponseModel();
            List<PointConfigDto> responseData = pointConfigService.getDataList(searchData);
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
            boolean checkDelete = pointConfigService.updateDeleteFlag(pointConfigId);
            if(checkDelete)
                return ResponseModel.ok(CommonEnum.CODE_000003.getCode(), CommonEnum.CODE_000003.getDesc());
            else
                return ResponseModel.error(CommonEnum.ERRORCODE_100001.getCode(), CommonEnum.ERRORCODE_100001.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }



}
