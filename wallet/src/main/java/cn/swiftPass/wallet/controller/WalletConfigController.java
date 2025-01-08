package cn.swiftPass.wallet.controller;
import cn.swiftPass.wallet.common.enums.CommonEnum;
import cn.swiftPass.wallet.dto.walletConfig.WalletConfigDto;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigRequest;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigSearchRequest;
//import cn.swiftPass.wallet.response.ResponseModel;
import cn.swiftPass.wallet.response.ResponseModel;
import cn.swiftPass.wallet.service.WalletConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/wallet")
public class WalletConfigController {

    @Autowired
    WalletConfigService walletConfigService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseModel create(@RequestBody WalletConfigRequest requestData) {
        try {
            walletConfigService.create(requestData);
            return ResponseModel.ok(CommonEnum.CODE_000001.getCode(), CommonEnum.CODE_000001.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseModel update(@RequestBody WalletConfigRequest requestData) {
        try {
            walletConfigService.update(requestData);
            return ResponseModel.ok(CommonEnum.CODE_000002.getCode(), CommonEnum.CODE_000002.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

    @RequestMapping(value = "/getDataById", method = RequestMethod.GET)
    public ResponseModel getDataById(@RequestParam("id") long walletConfigId) {
        try {
            ResponseModel responseModel = new ResponseModel();
            WalletConfigDto responseData = walletConfigService.getDataById(walletConfigId);
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
    public ResponseModel getDataList(@RequestBody WalletConfigSearchRequest searchData) {
        try {
            ResponseModel responseModel = new ResponseModel();
            List<WalletConfigDto> responseData = walletConfigService.getDataList(searchData);
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
    public ResponseModel delete(@RequestParam("id") long walletConfigId) {
        try {
            boolean checkDelete = walletConfigService.updateDeleteFlag(walletConfigId);
            if(checkDelete)
                return ResponseModel.ok(CommonEnum.CODE_000003.getCode(), CommonEnum.CODE_000003.getDesc());
            else
                return ResponseModel.error(CommonEnum.ERRORCODE_100001.getCode(), CommonEnum.ERRORCODE_100001.getDesc());
        } catch (Exception e) {
            return ResponseModel.error(CommonEnum.ERRORCODE_019999.getCode(), CommonEnum.ERRORCODE_019999.getDesc());
        }
    }

}
