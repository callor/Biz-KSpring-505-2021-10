package com.callor.readbook

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReadBookApplication

fun main(args: Array<String>) {
	runApplication<ReadBookApplication>(*args)
}
