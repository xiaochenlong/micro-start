package vip.corejava;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * @author xcl
 * @version 2020/9/15
 */

@SpringBootTest
@Slf4j
public class AppTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    void name() {
        log.info("----------{}", applicationContext);
    }
}
