package com.callor.spring.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

// @Entity
// @Table(name="tbl_buyer",schema = "naraDB"  )
class BuyerEntiry {

    @Id
    @Column(columnDefinition = "CHAR(4)", nullable = false)
    private val userid : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = false)
    private val name : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    private val tel : String? = null

    @Column(nullable = true)
    private val address : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    private val manager : String? = null

    @Column(columnDefinition = "VARCHAR(25)", nullable = true)
    private val man_tel : String? = null

    @Column(nullable = true)
    private val buy_total :Int = 0

}