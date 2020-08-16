package com.example.config;

import org.apache.camel.CamelContext;
import org.apache.camel.component.http.HttpComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CamelRunnerImpl implements ApplicationRunner {
    @Autowired
    private CamelContext context;
    @Override
    public void run(ApplicationArguments args) {
//        HttpComponent httpComponent = new HttpComponent();
//        context.addComponent("http", httpComponent);
//        System.out.println("加载成功");
    }
}
