package vip.corejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import vip.corejava.stream.Barista;

/**
 * @author xcl
 * @version 2020/9/15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"vip.corejava.dict.client"})
@EnableBinding(Barista.class)
public class MgmtApplication {

    @LoadBalanced
    @Bean
    public RestTemplate loadbalancedRestTemplate() {
        return new RestTemplate();
    }



    public static void main(String[] args) {
        SpringApplication.run(MgmtApplication.class, args);
    }
}
