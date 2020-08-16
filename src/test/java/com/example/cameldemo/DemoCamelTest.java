package com.example.cameldemo;

import com.example.processdata
        .FileProcessRouteBuilder;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoCamelTest extends CamelTestSupport {
    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new FileProcessRouteBuilder();
    }
}
