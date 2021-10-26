package com.callor.spring.service.impl

import com.callor.spring.config.logger
import com.callor.spring.models.Buyer
import com.callor.spring.repository.BuyerRepository
import com.callor.spring.service.BuyerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.util.*

/**
 * 클래스의 매개변수를 사용하여 생성자 주입하기
 * class 클래스( 주입받을객체, 변수 선언 )
 *
 */
@Service("bServiceV1")
class BuyerServiceImplV1(val bRepo:BuyerRepository ):BuyerService {

    // setter 주입으로 와이어링 하기
//    @Autowired
//    private lateinit var bDao : BuyerRepository

    override fun selectAll(): Array<Buyer> {
        return bRepo.findAll().toTypedArray()
    }

    override fun selectAll(pageable: Pageable): Page<Buyer> {
        return bRepo.findAll(pageable)
    }

    override fun selectWithPageable(intPage: Int): Array<Buyer> {
        // PageRequest.of(몇페이지, 몇개)
        val pageRequest = PageRequest.of(intPage, 10)
        return bRepo.findWithpagination(pageRequest).toTypedArray()
    }


    override fun findById(userid: String): Buyer {
        // repository 의 findById() 는
        // 실제 데이터(Buyer)를 Optional 이라는 특별한 객체로
        // wrapping 하여 가져온다
        // 필요한 데이터는 .get() method 를 사용하여
        // 한번 더 추출해 주어야 한다
        val buyer:Optional<Buyer> = bRepo.findById(userid)
        return buyer.get()
    }

    override fun findByName(name: String): Array<Buyer> {
        return  bRepo.findByName(name)

    }

    override fun findByTel(tel: String): Array<Buyer> {
        return bRepo.findByTel(tel)
    }

    // 새로운 고객 ID(userid)를 생성하여 Buyer 에 담아서 return
    override fun insert(): Buyer {
        var userid = bRepo.maxUserId()
        /**
         * Repo 에서 return 받은 userid 에서 1번위부터(두 번째 문자열)
         * 잘라서 정수로 변환하여 userSeq 에 담아라
         * 만약 exception 이 발생하면 console 에 표시하고
         * 1 을 담아라
         */
        val userSeq = try {
            // B012
            userid?.substring(1)?.toInt()
        } catch (e: Exception) {
            logger().debug("고객데이터 없음")
            1
        }
        if (userSeq != null) {
            userid = String.format("B%03d",userSeq + 1)
        }
        return Buyer(userid = userid)
    }

    override fun insert(buyer: Buyer): Buyer {
        // Insert Or Update
        return bRepo.save(buyer)
    }

    override fun delete(userid: String) {
        bRepo.deleteById(userid)
    }

    override fun update(buyer: Buyer): Buyer {
        return bRepo.save(buyer)
    }


}