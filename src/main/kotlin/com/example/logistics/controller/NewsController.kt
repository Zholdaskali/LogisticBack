package com.example.logistics.controller

import com.example.logistics.model.News
import com.example.logistics.repository.NewsRepository
import com.example.logistics.response.MessagedResponse
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/news")
@CrossOrigin(origins = ["*"])
class NewsController(
    private val newsRepository: NewsRepository
) {
    @GetMapping("/public")
    fun getAll(): MessagedResponse<List<News>> {
        return newsRepository.findAll().let(MessagedResponse.Companion::of)
    }
}