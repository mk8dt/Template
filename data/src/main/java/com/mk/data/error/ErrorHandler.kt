package com.mk.data.error

const val AUTHORIZATION_FORBIDDEN = "Don't have permission"
const val NOT_FOUND = "Object not found"
const val SERVER_ERROR = "Server error"
const val UNKNOWN_ERROR = "Unexpected error"

class ErrorHandler {

    fun checkErrorCode(code: Int): String = when (code) {
        200 -> "Success"
        204 -> ""
        401 -> AUTHORIZATION_FORBIDDEN
        404 -> NOT_FOUND
        500 -> SERVER_ERROR
        else -> UNKNOWN_ERROR
    }

}
