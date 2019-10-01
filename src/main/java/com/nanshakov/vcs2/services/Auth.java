package com.nanshakov.vcs2.services;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Auth {

    @Value("${api.appId}")
    Integer appId;
    @Value("${api.secret}")
    String secret;
    @Value("${api.redirectUrl}")
    String redirectUrl;
    private String token;

    String getCode() {
        return "55cd599cd21af55545";
    }

    public String getToken(String code) throws ClientException, ApiException {
        if (token == null) {
            TransportClient transportClient = new HttpTransportClient();
            VkApiClient vk = new VkApiClient(transportClient);
            UserAuthResponse authResponse = vk.oAuth()
                    .userAuthorizationCodeFlow(appId, secret, redirectUrl, code)
                    .execute();
            token = authResponse.getAccessToken();
            return token;
        }
        return token;
    }
}
