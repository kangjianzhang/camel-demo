package com.example.recivedate;

import com.example.processdata.FileProcessRouteBuilder;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

@RestController
public class ReciveDateController {
    @Autowired
    private CamelContext context;

    @Autowired
    private FileProcessRouteBuilder fileProcessRouteBuilder;

    @RequestMapping(path = {"/send"})
    public void send() throws Exception {
//        fileProcessRouteBuilder.
//        fileProcessRouteBuilder.
//        context.addRoutes(fileProcessRouteBuilder);
//        context.getRoute("route01").setAutoStartup(true);
//        fileProcessRouteBuilder.se
    }

    @PostMapping("/receive")
    public void receive(String content, HttpServletRequest httpServletRequest){
        System.out.println(content);
    }
}
