package com.callor.readbook.service.impl

import com.callor.readbook.models.BookDTO
import com.callor.readbook.models.ReadBookDTO
import com.callor.readbook.models.ReadBookVO
import com.callor.readbook.repository.BookRepository
import com.callor.readbook.repository.ReadBookRepository
import com.callor.readbook.service.ReadBookService
import org.springframework.stereotype.Service

@Service("readBookServiceV1")
class ReadBookServiceImplV1(
        val readBookDao:ReadBookRepository,
        val bookDao:BookRepository):ReadBookService {
    override fun readBookInsert(readBook: ReadBookVO) {

        val readBookDTO = ReadBookDTO(
            isbn = readBook.isbn,
            title = readBook.title,
            content = readBook.content
        )
        val bookDTO = BookDTO(
            isbn = readBook.isbn,
            title = readBook.title)

        readBookDao.save(readBookDTO)
        bookDao.save(bookDTO)
    }
}