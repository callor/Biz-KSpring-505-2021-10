package com.callor.readbook.config

import org.springframework.boot.SpringBootConfiguration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 * Controller 를 만들지 않고 MVC 패턴의 가상이 Request 를 처리하는
 * 클래스
 */
@SpringBootConfiguration
class WebMVCReqController:WebMvcConfigurer {

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry
            .addViewController("/member/view")
            .setViewName("member/view")
    }
}







