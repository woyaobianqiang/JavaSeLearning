package com.example.dingdinglogin.controller;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiSnsGetuserinfoBycodeRequest;
import com.dingtalk.api.request.OapiUserGetbyunionidRequest;
import com.dingtalk.api.request.OapiV2UserGetRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiSnsGetuserinfoBycodeResponse;
import com.dingtalk.api.response.OapiUserGetbyunionidResponse;
import com.dingtalk.api.response.OapiV2UserGetResponse;
import com.taobao.api.ApiException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zsy
 */
@RestController
public class DingDingLoginController {

    public static final String LOGIN_APP_ID = "dingoanrw262qqelcpwe3m";

    public static final String APP_SECRET = "df9k63qMq0wdX_6YMQtM452cZ9vIpE5YyMDZFkYOUbbuqKruFRAa_f83M_c8AIXs";

    public static final String APP_KEY = "ding48ny4kojhdx8qp7u";

    public static final String LOGIN_APP_SECRET = "ekcafh7DFUxftaUUFIIxIBj1sFldvgIaQc7n3CsZeK2_Qk3ep-DPG7HN16-vzmr9";

    @RequestMapping(value = "/dingdingLogin")
    public void dingdingLogin(HttpServletResponse response) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://oapi.dingtalk.com/connect/qrconnect?appid=" + LOGIN_APP_ID)
                .append("&response_type=code&scope=snsapi_login")
                .append("&redirect_uri=" + "http://localhost:8080/dingdingCallback");
        try {
            response.sendRedirect(stringBuilder.toString());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 钉钉回调验证
     */
    @RequestMapping(value = "/dingdingCallback")
    public String dingdingCallback(String code) throws ApiException {
        // 获取access_token，注意正式代码要有异常流处理
        String access_token = getAccessToken();

        // 通过临时授权码获取授权用户的个人信息
        DefaultDingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
        OapiSnsGetuserinfoBycodeRequest reqBycodeRequest = new OapiSnsGetuserinfoBycodeRequest();
        // 通过扫描二维码，跳转指定的redirect_uri后，向url中追加的code临时授权码
        reqBycodeRequest.setTmpAuthCode(code);
        OapiSnsGetuserinfoBycodeResponse bycodeResponse = client2.execute(reqBycodeRequest, LOGIN_APP_ID, LOGIN_APP_SECRET);

        // 根据unionid获取userid
        String unionid = bycodeResponse.getUserInfo().getUnionid();
        DingTalkClient clientDingTalkClient = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/user/getbyunionid");
        OapiUserGetbyunionidRequest reqGetbyunionidRequest = new OapiUserGetbyunionidRequest();
        reqGetbyunionidRequest.setUnionid(unionid);
        OapiUserGetbyunionidResponse oapiUserGetbyunionidResponse = clientDingTalkClient.execute(reqGetbyunionidRequest, access_token);

        // 根据userId获取用户信息
        String userid = oapiUserGetbyunionidResponse.getResult().getUserid();
        DingTalkClient clientDingTalkClient2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/get");
        OapiV2UserGetRequest reqGetRequest = new OapiV2UserGetRequest();
        reqGetRequest.setUserid(userid);
        reqGetRequest.setLanguage("zh_CN");
        OapiV2UserGetResponse rspGetResponse = clientDingTalkClient2.execute(reqGetRequest, access_token);
        System.out.println(rspGetResponse.getBody());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userInfo", rspGetResponse.getBody());
//        return ServiceResult.success(map);
        return JSONObject.toJSONString(map);
    }

    /**
     * 获取授权用户的个人信息
     * openapi@dingtalk
     *
     * @return
     * @throws Exception ServiceResult<Map<String,Object>>
     *                   2020-11-4
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public String getUserInfo(@RequestParam("code") String code) throws ApiException {
        // 获取access_token，注意正式代码要有异常流处理
        String access_token = getAccessToken();

        // 通过临时授权码获取授权用户的个人信息
        DefaultDingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
        OapiSnsGetuserinfoBycodeRequest reqBycodeRequest = new OapiSnsGetuserinfoBycodeRequest();
        // 通过扫描二维码，跳转指定的redirect_uri后，向url中追加的code临时授权码
        reqBycodeRequest.setTmpAuthCode(code);
        OapiSnsGetuserinfoBycodeResponse bycodeResponse = client2.execute(reqBycodeRequest, LOGIN_APP_ID, LOGIN_APP_SECRET);

        // 根据unionid获取userid
        String unionid = bycodeResponse.getUserInfo().getUnionid();
        DingTalkClient clientDingTalkClient = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/user/getbyunionid");
        OapiUserGetbyunionidRequest reqGetbyunionidRequest = new OapiUserGetbyunionidRequest();
        reqGetbyunionidRequest.setUnionid(unionid);
        OapiUserGetbyunionidResponse oapiUserGetbyunionidResponse = clientDingTalkClient.execute(reqGetbyunionidRequest, access_token);

        // 根据userId获取用户信息
        String userid = oapiUserGetbyunionidResponse.getResult().getUserid();
        DingTalkClient clientDingTalkClient2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/get");
        OapiV2UserGetRequest reqGetRequest = new OapiV2UserGetRequest();
        reqGetRequest.setUserid(userid);
//        reqGetRequest.setLanguage("zh_CN");
        OapiV2UserGetResponse rspGetResponse = clientDingTalkClient2.execute(reqGetRequest, access_token);
        System.out.println(rspGetResponse.getBody());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userInfo", rspGetResponse.getBody());
//        return ServiceResult.success(map);
        return JSONObject.toJSONString(map);

    }

    /**
     * 获取授权用户的个人信息
     * openapi@dingtalk
     *
     * @return
     * @throws Exception ServiceResult<Map<String,Object>>
     *                   2020-11-4
     */
//    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
//    public ResultPO getUserInfo(@RequestParam("authCode") String code, HttpServletRequest request) throws ApiException {
//        // 获取access_token，注意正式代码要有异常流处理
//        String access_token = this.getAccessToken();
//        // 通过临时授权码获取授权用户的个人信息
//        DefaultDingTalkClient client2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/sns/getuserinfo_bycode");
//        OapiSnsGetuserinfoBycodeRequest reqBycodeRequest = new OapiSnsGetuserinfoBycodeRequest();
//        // 通过扫描二维码，跳转指定的redirect_uri后，向url中追加的code临时授权码
//        reqBycodeRequest.setTmpAuthCode(code);
//        OapiSnsGetuserinfoBycodeResponse bycodeResponse = client2.execute(reqBycodeRequest, SysConfigCache.appId, SysConfigCache.appSecret);
//
//        // 根据unionid获取userid
//        String unionid = bycodeResponse.getUserInfo().getUnionid();
//        DingTalkClient clientDingTalkClient = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/user/getbyunionid");
//        OapiUserGetbyunionidRequest reqGetbyunionidRequest = new OapiUserGetbyunionidRequest();
//        reqGetbyunionidRequest.setUnionid(unionid);
//        OapiUserGetbyunionidResponse oapiUserGetbyunionidResponse = clientDingTalkClient.execute(reqGetbyunionidRequest, access_token);
//
//        // 根据userId获取用户信息
//        String userid = oapiUserGetbyunionidResponse.getResult().getUserid();
//        DingTalkClient clientDingTalkClient2 = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/v2/user/get");
//        OapiV2UserGetRequest reqGetRequest = new OapiV2UserGetRequest();
//        reqGetRequest.setUserid(userid);
//        reqGetRequest.setLanguage("zh_CN");
//        OapiV2UserGetResponse rspGetResponse = clientDingTalkClient2.execute(reqGetRequest, access_token);
//        System.out.println(rspGetResponse.getBody());
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("userInfo", rspGetResponse.getBody());
//        return ResultPO.success(map);
//    }

    /**
     * 获取accessToken
     *
     * @return
     * @throws ApiException
     */
    public String getAccessToken() throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(APP_KEY);
        request.setAppsecret(APP_SECRET);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        return response.getAccessToken();
    }

}
