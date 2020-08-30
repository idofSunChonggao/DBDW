package com.sunchg.dbdw;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class WebserviceApplicationTests {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        logger.trace("这是trace日志");
        logger.debug("这是debug日志");
        //root级别
        logger.info("info");
        logger.warn("warn");
        logger.error("error");

    }


}
