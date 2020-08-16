package com.example.processdata;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@Component
public class FileProcessRouteBuilder extends RouteBuilder{
    @Autowired
    private CamelContext camelContext;
    @Override
    public void configure() throws Exception {
        String routeId = "route1";
        // 完成时结束路由生命周期
        onCompletion().process(new Processor() {
            @Override
            public void process(Exchange exchange) throws Exception {
                exchange.getContext().getInflightRepository().remove(exchange, routeId);
                exchange.getContext().stop();
                System.out.println("销毁路由" + routeId);
            }
        });

        from("file:data/inbox?fileName=data.csv&delete=true")
                .process(exchange -> {
                    Message message = exchange.getMessage();
                    File body = exchange.getMessage().getBody(File.class);
                    BufferedReader in = new BufferedReader(new FileReader(body));
                    StringBuffer stringBuffer = new StringBuffer();
                    in.lines().forEach(stringBuffer::append);
                    message.setHeader(Exchange.HTTP_QUERY, "content=" + stringBuffer.toString());
                })
                .routeId(routeId)
                .setHeader("CamelHttpMethod", constant("POST"))
                .to("http://localhost:8080/receive");
    }
}
