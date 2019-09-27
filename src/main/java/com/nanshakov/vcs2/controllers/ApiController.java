package com.nanshakov.vcs2.controllers;

import com.nanshakov.vcs2.services.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
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
    public static String startUp(@CookieValue(value = "GKey") String gKey, @RequestBody List<String> body,
                                 HttpServletResponse response) {
//        body.forEach(l -> ProcessingCache.getInstance().push(gKey, new ProcessingStatusDto(gKey, l)));
        return "/getProcessing";
    }

    @GetMapping("/api/getResult")
    public static Map getResult(@CookieValue(value = "GKey") String gKey, HttpServletResponse response) {
        //return Collections.singletonMap("response", ProcessingCache.getInstance().get(gKey));
        return new HashMap();
    }
}
