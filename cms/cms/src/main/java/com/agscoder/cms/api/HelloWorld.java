package com.agscoder.cms.api;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorld {
    //Request mapping is used to call th method on rowser
    @RequestMapping(value = "/hello")

    public String sayHello(){
        return "Hello AGS";
    }
}
