package com.callor.spring.config

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringBootConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import java.nio.file.Path
import java.nio.file.Paths
import javax.transaction.Transactional

@SpringBootConfiguration
class BuyerDataFromFile {

    /**
     * @Value()
     * *.properties 또는 *.yml 파일에 설정된
     * 속성(com.callor.spring.student-file) 을 참조하여
     * 속성에 설정된 값(주로 문자열)을 가져와서
     * dataFile 변수에 담아라
     */
    @Value("\${com.callor.spring.student-file}")
    private val dataFile:String? = null

    @Bean
    @Transactional
    fun dataFromFile():CommandLineRunner {
        logger().debug("Data File: {}",dataFile)

        // datFile 변수를 null 허용변수로 만들었기 때문에
        // 다른 변수에 담을때는 아래와 같은 키워드를 사용한다
        // dataFile 변수에 담긴 값을 {} 부분으로 전달(let, 할당)하고
        // ClassPathResource() 함수의 매개변수로 전달하여라
        // ClassPathResource() 함수가 return하는 값을 변수 file에 담아라

        // val file = ClassPathResource("student.txt")
        // val file = ClassPathResource(dataFile)
        val file = dataFile?.let { ClassPathResource(it) }

        val path: Path = Paths.get(file?.uri)
        val fileList : List<String> =





        return CommandLineRunner {
            logger().debug(it.toString())
        }
    }

}