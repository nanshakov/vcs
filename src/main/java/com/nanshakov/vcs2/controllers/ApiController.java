package com.nanshakov.vcs2.controllers;

import com.nanshakov.vcs2.services.Auth;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ApiController {

    @Autowired
    private Auth auth;

    @PostMapping("/api/start")
    public String start(@RequestBody List<String> body, HttpServletResponse response) {
        return "getProcessing";
    }

    @GetMapping("/api/result")
    public Map getResult(HttpServletResponse response) {
        return new HashMap();
    }

    @GetMapping("/api/token")
    public String getToken(HttpServletResponse response) throws ClientException, ApiException {
        return auth.getToken(auth.getCode());
    }
}
