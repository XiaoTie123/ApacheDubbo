package cn.swiftPass.cashBack.campaign.controller;

import cn.swiftPass.cashBack.campaign.common.enums.CommonEnum;
import cn.swiftPass.cashBack.campaign.response.ResponseModel;
import cn.swiftPass.wallet.dto.walletConfig.WalletConfigDto;
import cn.swiftPass.wallet.repository.walletConfig.WalletConfigRepository;
import cn.swiftPass.wallet.request.walletConfig.WalletConfigSearchRequest;
import cn.swiftPass.wallet.service.WalletConfigService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/cashBackWallet")
public class WalletConfigController {

    @DubboReference
    WalletConfigService walletConfigService;

    @RequestMapping(value = "/getDataList", method = RequestMethod.POST)
    public ResponseModel getDataList(@RequestBody WalletConfigSearchRequest searchData) {
        try {
            ResponseModel responseModel = new ResponseModel();
            List<WalletConfigDto> responseData = walletConfigService.create(searchData);
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

}
