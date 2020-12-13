package vip.corejava.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vip.corejava.dict.client.BrandClient;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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


    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/dc")
    public Object discoveryClient() {
        List<String> services = discoveryClient.getServices();
        Map<String, List<ServiceInstance>> data = services.stream().collect(Collectors.toMap(s -> s, s -> discoveryClient.getInstances(s)));
        return data;
    }

    @RequestMapping("/")
    public String index() {
        return "app.hello word" + LocalDateTime.now();
    }

    @RequestMapping("/restToDict")
    public String toMgmt() {
        String mgmtRet = restTemplate.getForObject("http://micro-start-dict/page-brands", String.class);
        return "app->toDict" + LocalDateTime.now() + "\t" + mgmtRet;
    }

    @RequestMapping("/toDict")
    public String toDict() {
        return "app->dict" + LocalDateTime.now() + "\t" + brandClient.getBrands();
    }

}
