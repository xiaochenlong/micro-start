package vip.corejava.web.controller;

import org.springframework.web.bind.annotation.RestController;
import vip.corejava.client.dict.BrandClient;

import java.util.Arrays;
import java.util.List;

/**
 * @author xcl
 * @version 2020/11/1
 */
@RestController
public class BrandController implements BrandClient {

    @Override
    public List<Object> getBrands() {
        return Arrays.asList("哈佛", "吉利", "比亚迪");
    }

    @Override
    public List<Object> pageBrands() {
        return Arrays.asList("大众", "宝马", "奥迪");
    }
}
