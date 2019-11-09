package com.seal.auth.endpoint;

import com.seal.common.constant.enums.CommonEnums;
import com.seal.common.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhiqiang.feng
 * @version 1.0
 * @date-time 2019/11/6 11:50
 * @description
 **/
@Slf4j
@RestController
@RequestMapping("/token")
public class SctTokenEndpoint {

    @Autowired
    private TokenStore tokenStore;

    @DeleteMapping("/logout")
    public Result logout(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authHeader) {
        log.info("Logout  >>  ....");
        if (StringUtils.isBlank(authHeader)) {
            return new Result(CommonEnums.LOGOUT_ERROR);
        }
        String tokenValue = authHeader.replace(OAuth2AccessToken.BEARER_TYPE.toLowerCase(), "").trim();
        OAuth2AccessToken oAuth2AccessToken = tokenStore.readAccessToken(tokenValue);
        if (oAuth2AccessToken == null || StringUtils.isBlank(oAuth2AccessToken.getValue())) {
            return new Result(CommonEnums.LOGOUT_ERROR);
        }
        tokenStore.removeAccessToken(oAuth2AccessToken);
        return new Result();
    }
}
