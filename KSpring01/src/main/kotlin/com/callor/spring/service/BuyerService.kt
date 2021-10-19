package com.callor.spring.service

import com.callor.spring.model.Buyer

interface BuyerService {
    fun selectAll():Array<Buyer>
    fun findById(id:String):Buyer
}