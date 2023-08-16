package com.kiran.messenger.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class UrlConCheckController {
    private static final String SITE_UP = "site is up!";
    private static final String SITE_DOWN = "site is down!";
    private static final String INVALID_URL = "Invalid URL!";

    @GetMapping("/check")
    public String getConResponse(@RequestParam String url){
        System.out.println("Checking connection for URL:"+url);
        try {
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("ResponseCode:"+responseCode);
            int responseCodeCat =responseCode/100;
            System.out.println("Response Code Category:"+responseCodeCat);
            connection.disconnect();
            if(responseCodeCat ==2 || responseCodeCat ==3) {
                return SITE_UP;
            } else return SITE_DOWN;
        } catch (MalformedURLException e) {
           return INVALID_URL;
        } catch (IOException e) {
            return SITE_DOWN;
        }
    }

}
