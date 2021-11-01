package com.callor.readbook.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Controller
class HomeController {

    @RequestMapping(value=["/"],method=[RequestMethod.GET])
    fun home() : String {
        return "redirect:/member/mypage"
    }
}