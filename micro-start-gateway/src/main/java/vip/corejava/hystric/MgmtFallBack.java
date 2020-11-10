package vip.corejava.hystric;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xcl
 * @version 2020/11/10
 */
@RestController
@RequestMapping("/hystric")
public class MgmtFallBack {

    @RequestMapping("/mgmt")
    public String mgmt() {
        return "error mgmt server!!!";
    }

}
