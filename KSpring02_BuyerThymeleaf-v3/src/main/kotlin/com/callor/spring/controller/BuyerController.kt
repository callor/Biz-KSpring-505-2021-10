package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
@RequestMapping(value=["/buyer"])
class BuyerController(val bService:BuyerService) {


    // @GetMapping(name="/list")
     @RequestMapping(value=["/list"],method=[RequestMethod.GET])
    fun list(model: Model):String {
        val buyerList = bService.selectAll()
        model["BUYERS"] = buyerList
        return "buyer/list"
    }

    // localhost:8080/buyer/detail
    @RequestMapping(value=["/detail"],method=[RequestMethod.GET])
    fun detail( model:Model, @RequestParam("userid") userid:String):String {

        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/detail" // detail.html 을 열어라

    }

    @RequestMapping(value=["/insert"],method=[RequestMethod.GET])
    fun insert(): String {
//        val insertBuyer = ConfigData.BUYER_LIST[0]
//        bService.insert(insertBuyer)
        return "buyer/write"
    }

}