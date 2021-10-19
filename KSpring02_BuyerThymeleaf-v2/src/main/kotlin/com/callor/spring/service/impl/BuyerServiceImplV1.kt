package com.callor.spring.service.impl

import com.callor.spring.models.Buyer
import com.callor.spring.service.BuyerService

class BuyerServiceImplV1:BuyerService {

    // 현재 BuyerServiceImplV1 에서 사용할 가상 데이터를
    // 선언하기
    // private : 여기 클래스 내부에서만 사용하는 static 변수 선언하기
    private companion object {
        val buyerList = (

                )
    }


    override fun selectAll(): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun findById(userid: String): Buyer {
        TODO("Not yet implemented")
    }

    override fun findByName(name: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun findByTel(name: String): Array<Buyer> {
        TODO("Not yet implemented")
    }

    override fun insert(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

    override fun delete(userid: String): Int {
        TODO("Not yet implemented")
    }

    override fun update(buyer: Buyer): Int {
        TODO("Not yet implemented")
    }

}