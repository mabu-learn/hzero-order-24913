package com.hzero.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger Api 描述配置
 */
@Configuration
public class SwaggerConfig {

    public static final String TOTAL ="OrderTotal";
    public static final String DETAIL = "OrderDetail";
    @Autowired
    public SwaggerConfig(Docket docket) {
        docket.tags(
                new Tag(TOTAL, "订单汇总"),
                new Tag(DETAIL,"订单明细")
        );
    }
}
