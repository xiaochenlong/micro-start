package vip.corejava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

/**
 * @author xcl
 * @version 2020/10/25
 */

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("/")
    public String index() {
        return "mgmt.hello word" + LocalDateTime.now();
    }

    @RequestMapping("/toApp")
    public String toMgmt() {
        String appRet = restTemplate.getForObject("http://micro-start-app", String.class);
        return "mgmt->app" + LocalDateTime.now() + "\t" + appRet;
    }

}
