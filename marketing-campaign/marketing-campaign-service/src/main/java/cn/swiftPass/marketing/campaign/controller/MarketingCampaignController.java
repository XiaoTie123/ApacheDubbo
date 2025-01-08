package cn.swiftPass.marketing.campaign.controller;

import cn.swiftPass.marketing.campaign.response.ResponseModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("v1/marketing")
public class MarketingCampaignController {

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ResponseModel create() {
        String requestUrl = "http://localhost:8085/v1/pointConfig/create";
        String json = "{\n" +
                "    \"name\": \"Apache Dubbo\",\n" +
                "    \"description\": \"Marketing By Transfer Amount\",\n" +
                "    \"transferType\": 1,\n" +
                "    \"transferAmount\": 10000,\n" +
                "    \"point\": 1,\n" +
                "    \"percentage\": 0\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(json, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseModel> responseEntity = restTemplate.postForEntity(requestUrl, requestEntity, ResponseModel.class);
        return responseEntity.getBody();
    }
}
