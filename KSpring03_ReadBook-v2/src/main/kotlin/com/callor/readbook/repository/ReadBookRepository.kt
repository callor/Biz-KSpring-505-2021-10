package com.callor.readbook.repository

import com.callor.readbook.models.BookDTO
import com.callor.readbook.models.ReadBookDTO
import org.springframework.data.jpa.repository.JpaRepository

interface ReadBookRepository:JpaRepository<ReadBookDTO,Long> {}
interface BookRepository:JpaRepository<BookDTO,String>{}

