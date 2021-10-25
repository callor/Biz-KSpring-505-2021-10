package com.callor.spring.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * Kotlin 은 객체지향 프로그래밍 언어 이면서
 * 함수지향 프로그래밍 언어
 *
 * inline 함수
 * 클래스에서 함수를 호출하여 사용할때
 * 자동으로 호출한 클래스 자체를 함수에 전달하고
 * 전달받은 클래스를 사용하여
 * 코드가 실행되는 동안 객체를 다시 생성하는
 * 독특한 함수
 */
inline fun <reified T:Any> T.logger(): Logger {
    return LoggerFactory.getLogger( T::class.java)
}
inline fun <reified T:Any> T.loggerFor()
        = LoggerFactory.getLogger(T::class.java)
