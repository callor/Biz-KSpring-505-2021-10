package com.callor.react;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value="/home",method= RequestMethod.GET)
    public String home() {
        return "반갑습니다 우리나라만세";
    }
}
