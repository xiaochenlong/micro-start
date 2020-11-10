package vip.corejava.hystric;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcl
 * @version 2020/11/10
 */
@RestController
@RequestMapping("/hystric")
public class AppFallBack {

    @RequestMapping("/app")
    public String app() {
        return "error app server!!!";
    }

}