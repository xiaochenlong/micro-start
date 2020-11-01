package vip.corejava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vip.corejava.client.dict.BrandClient;

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

    @Autowired
    private BrandClient brandClient;

    @RequestMapping("/")
    public String index() {
        return "mgmt.hello word" + LocalDateTime.now();
    }

    @RequestMapping("/restToDict")
    public String toMgmt() {
        String appRet = restTemplate.getForObject("http://micro-start-dict/brands", String.class);
        return "mgmt->dict" + LocalDateTime.now() + "\t" + appRet;
    }

    @RequestMapping("/toDict")
    public String toDict() {
        return "mgmt->dict" + LocalDateTime.now() + "\t" + brandClient.pageBrands();
    }
}
