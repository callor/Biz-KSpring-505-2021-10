package com.callor.spring.models

/**
 * DTO(VO) 클래스
 */
data class Buyer(
    val userid : String,
    val name : String,
    val tel:String,
    val address : String,
    val manager : String,
    val man_tel : String,
    val buy_total : Int
)
