package com.example.logistics.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "t_news")
data class News(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "news_title", nullable = false)
    val newsTitle: String,

    @Column(name = "news_content", nullable = false, columnDefinition = "TEXT")
    val newsContent: String,

    @Column(name = "news_date", nullable = false)
    val newsDate: LocalDate,

    @Column(name = "image_path", nullable = false)
    val imagePath: String
)
