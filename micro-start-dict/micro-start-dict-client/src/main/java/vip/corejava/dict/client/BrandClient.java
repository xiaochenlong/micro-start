package vip.corejava.dict.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xcl
 * @version 2020/11/1
 */
@FeignClient("micro-start-dict")
public interface BrandClient {

    @RequestMapping(method = RequestMethod.GET, value = "/brands")
    List<Object> getBrands();

    @RequestMapping(method = RequestMethod.GET, value = "/page-brands")
    List<Object> pageBrands();

}
