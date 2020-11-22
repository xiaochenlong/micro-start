package vip.corejava.dict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author xcl
 * @version 2020/11/1
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DictApplication {

    @LoadBalanced
    @Bean
    public RestTemplate loadbalancedRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(DictApplication.class, args);
    }
}