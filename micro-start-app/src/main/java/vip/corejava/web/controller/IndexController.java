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
        return "app.hello word" + LocalDateTime.now();
    }

    @RequestMapping("/toMgmt")
    public String toMgmt() {
        String mgmtRet = restTemplate.getForObject("http://micro-start-mgmt", String.class);
        return "app->mgmt" + LocalDateTime.now() + "\t" + mgmtRet;
    }

}
