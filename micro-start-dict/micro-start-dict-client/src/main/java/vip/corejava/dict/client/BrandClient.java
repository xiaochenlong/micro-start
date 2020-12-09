package vip.corejava.dict.client;

import feign.Logger;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xcl
 * @version 2020/11/1
 */
@FeignClient(name = "micro-start-dict", value = "micro-start-dict",
        fallback = BrandClient.BrandClientFallBack.class,
        configuration = BrandClientConfig.class)
public interface BrandClient {

    @RequestMapping(method = RequestMethod.GET, value = "/brands")
    List<Object> getBrands();

    @RequestMapping(method = RequestMethod.GET, value = "/page-brands")
    List<Object> pageBrands();

    @Component
    static class BrandClientFallBack implements BrandClient {

        @Override
        public List<Object> getBrands() {
            return null;
        }

        @Override
        public List<Object> pageBrands() {
            return null;
        }
    }
}

class BrandClientConfig {
    //@Bean
    public Logger.Level logger() {
        return Logger.Level.FULL;
    }
}