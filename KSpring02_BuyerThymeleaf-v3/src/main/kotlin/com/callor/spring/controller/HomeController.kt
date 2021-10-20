package com.callor.spring.controller

import com.callor.spring.ConfigData
import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService
import com.callor.spring.service.impl.BuyerServiceImplV1
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    /**
     * lateinit var
     *  특별히 변수, 객체를 선언할때 즉시 초기화 하지 않고
     *  나중에 초기화를 하겠다 라는 의미미
     *
     *  Spring 환경에서는 Component(Service, Dao 등등) 객체는
     *  코드에서 직접 초기화 하지 않는다
     *  코드에서는 선언만 해두고 @Autowired 설정을 하면
     *  Spring Ioc, DI 등의 기능에 의해
     *  (나중에, 필요할때) 자동으로 주입이 된다
     *
     *  반드시 lateinit 키워드를 부착하여 선언해야 한다
     */
    @Autowired
    private lateinit var bService:BuyerService

    /**
     * Spring 일반 Controller 에서
     * method 가 문자열을 return 하면
     * view 파일을 열어서 rendering  하여 client 로 보내라
     *
     * RESTful API 방식이다
     * RestController 또는 method 에 @RespnsBody 가 부착되면
     * 문자열을 그대로 client 로 보내라
     */
    @RequestMapping(value=["/"],method=[RequestMethod.GET])
    fun home(model:Model) :String {
        println( ConfigData.APP_NAME )
        println( ConfigData.APP_VERSION )

//        val userList = bService.selectAll()
        // model.addAttribute("USERS",userList)
//        model["USERS"] = userList
        return "redirect:/buyer/list"
    }

    /**
     *
     * @ResponseBody
     * 문자열, 객체, 배열 등등의 모든 데이터를
     * 있는 그대로 또는 JSON 형태로 변환하여
     * client 에 보내라
     *
     */
    @ResponseBody
    @RequestMapping(value=["/list"],method=[RequestMethod.GET])
    fun list() : Array<Buyer> {
        return bService.selectAll()
    }




}