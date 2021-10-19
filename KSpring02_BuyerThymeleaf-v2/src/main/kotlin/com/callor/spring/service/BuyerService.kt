package com.callor.spring.service

import com.callor.spring.models.Buyer

interface BuyerService {

    fun selectAll(): Array<Buyer>
    fun findById(userid: String): Buyer
    fun findByName(name: String): Array<Buyer>
    fun findByTel(name: String): Array<Buyer>

    fun insert(buyer: Buyer): Int
    fun delete(userid: String): Int
    fun update(buyer: Buyer): Int

}