package com.callor.readbook.models

data class ReadBookVO(
    var isbn: String,
    var title: String,
    var sdate: String,
    var stime: String,
    var etime: String,
    var subject: String,
    var content: String
)
