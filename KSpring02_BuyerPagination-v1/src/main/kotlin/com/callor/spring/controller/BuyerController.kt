package com.callor.spring.controller

import com.callor.spring.config.logger
import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes

/**
 * 2021-10-26
 * pagination 을 적용하기위하여 controller method 를 변경한다
 * 전체리스트를 보여주는 list() 함수를 변경한다
 * 가. list() 함수에 pagination 을 적용하기 위한 매개변수를 설정한다
 *
 */
@Controller
@RequestMapping(value = ["/buyer"])
class BuyerController(val bService: BuyerService) {

//    private val logger = LoggerFactory.getLogger(BuyerController::class.java)

    /**
     * list() 함수에 Pageable 클래스 객체를 매개변수로 선언
     * Pageable pageable
     * JPA 의 기능을 사용하여 pagination 을 구현하기 위한 하나의 도구
     * http://localhost:8080/erp/buyer/list
     *      ?page=10
     *      &size=10
     *      &sort=userid,desc
     *      &sort=name,asc
     *
     * 만약 주문정보를 조회한다면 다음처럼 최근입력한 자료가
     * 먼저 나타나도록 할때
     * http://localhost:8080/erp/sales/list
     *      ?page=10
     *      &size=10
     *      &sort=date,desc
     *      &sort=time,desc
     */

    // @GetMapping(name="/list")
    @RequestMapping(value = ["/list"], method = [RequestMethod.GET])
    fun list(model: Model,pageable: Pageable): String {

        logger().debug("여기는 list 함수")
        logger().debug("Pageable {}", pageable.toString())

        val buyerList = bService.selectAll(pageable)
        model["BUYERS"] = buyerList
        return "buyer/list"

    }

    @RequestMapping(value=["/sub_page"],method=[RequestMethod.GET])
    fun subPage(model:Model,pageable: Pageable):String {
        val buyerList = bService.selectAll(pageable)
        model["BUYERS"] = buyerList
        return "buyer/sub_page"
    }

    @RequestMapping(value = ["/list/{page}"], method = [RequestMethod.GET])
    fun list(model: Model,@PathVariable("page") page:String= "0"): String {

        val intPage = try{
            page.toInt()
        } catch (e:Exception)
        {
            logger().debug("매개변수 오류~~")
            0
        }
        logger().debug("여기는 page list 함수")
        val buyerList = bService.selectWithPageable(intPage)

        model["BUYERS"] = buyerList
        return "buyer/list"

    }



    // localhost:8080/buyer/detail
    @RequestMapping(value = ["/detail"], method = [RequestMethod.GET])
    fun detail(model: Model, @RequestParam("userid") userid: String): String {

        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/detail" // detail.html 을 열어라

    }

    /**
     *
     * ModelAndAttribute 속성, 기능
     * Controller 에서 Model 객체를 담고
     * form 화면을 rendering 하면
     *
     * 보통은 form 의 value 속성에 일일이
     * 데이터를 추가하여 작성을 한다
     *
     * ModelAttr 을 사용하면
     * 각각 view Template 의 고유 기능을 사용하여
     * id, name, value 값을 자동으로 채워넣는 기능을
     * 만들 수 있다
     *
     * thymeleaf template 을 사용할때는
     * form tag 에 model 에 담긴 object 를 지정해 주고
     * 각 input box 에서는 field 속성으로 해당 맴버변수(요소,속성)을
     * 지정해 주면
     * template 엔진이 rendering 을 수행하면서
     * input 에 필요한 요소들을 적절하게 생성해 준다
     */
    @RequestMapping(value = ["/insert"], method = [RequestMethod.GET])
    fun insert(model: Model): String {

        val buyer:Buyer = bService.insert()
        model["BUYER"] = buyer
        return "buyer/write"
    }

    @RequestMapping(value = ["/insert"], method = [RequestMethod.POST])
    fun insert(model: Model, buyer: Buyer): String {
        bService.insert(buyer)
        return "redirect:/buyer/list"
    }

    // localhost:8080/update/B001 URL 로 요청을 하면
    // B001 값을 userid 에 담아서 함수 내부로 전달된다
    @RequestMapping(value = ["/update/{userid}"], method = [RequestMethod.GET])
    fun update(model: Model, @PathVariable("userid") userid: String): String {
        val buyer = bService.findById(userid)
        model["BUYER"] = buyer
        return "buyer/write"
    }

    /**
     * update 를 실행할때
     *   localhost:8080/buyer/update/userid 값 으로
     *   URL 이 구성되어 있고
     *   update 화면에서 저장을 누르면
     *   원래 요청했던 주소가 action 이되어 요청되므로
     *   여기느에서는 userid 필요없지만
     *   PathVariable 로 설정해 주어야 한다
     */
    @RequestMapping(value = ["/update/{userid}"], method = [RequestMethod.POST])
    fun update(redirectAttributes: RedirectAttributes, buyer: Buyer, @PathVariable("userid") userid: String): String {

        logger().debug(buyer.toString())
        bService.update(buyer)

        /**
         * Spring MVC 에서는 model 에 변수를 담으면
         * redirect 를 실행할때 model 담긴 변수를
         * queryString 으로 부착하여 전송을 한다
         *
         * 이 기능이 boot 에서는 금지되고
         * 같은 기능을 구현하기 위하여
         * model 대신 RedirectAttributes 를 사용한다
         *
         */
        // localhost:8080/buyer/detail?userid=??? 형식으로
        // redirect 주소가 만들어진다
        redirectAttributes["userid"] = buyer.userid.toString()

        //
        // redirectAttributes 를 사용하지 않으면
        //      다음처럼 작성해야 한다.
        // return "redirect:/buyer/detail?userid="
        //          + buyer.userid.toString()
        //
        return "redirect:/buyer/detail"

    }

    @RequestMapping(value=["/delete/{userid}"],method=[RequestMethod.GET])
    fun delete(@PathVariable("userid") userid:String):String {
        bService.delete(userid)
        return "redirect:/buyer/list"
    }
}

