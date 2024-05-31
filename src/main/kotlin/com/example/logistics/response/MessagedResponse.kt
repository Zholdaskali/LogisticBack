package com.example.logistics.response

class MessagedResponse<T>(
    val body: T? = null,
    val message: String? = null,
) {

    companion object {

        fun empty(message: String) = MessagedResponse(message = message, body = null)

        fun <T> of(body: T) = MessagedResponse(body = body, message = null)
    }

}