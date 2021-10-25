package com.callor.spring.repository

import com.callor.spring.models.Sales
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

// Repository 인터페이스 생성
// JpaRepository 를 상속받고 데이터 DTO 와 테이블의 PK 값을
// Generic 으로 설정해 준다
@Repository
interface SalesRepository:JpaRepository<Sales,Long> {

    fun findByPname(pname:String) : Array<Sales>
    fun findByUserid(userid:String) : Array<Sales>

}