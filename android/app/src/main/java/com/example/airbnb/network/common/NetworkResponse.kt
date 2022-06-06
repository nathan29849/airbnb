package com.example.airbnb.network.common

// 응답을 래핑하는 데이터 클래스
sealed class NetworkResponse<out T : Any> {

    data class Success<T : Any>(val body: T) : NetworkResponse<T>() // Success: state code == 200

    data class Error(val errorType: ErrorType, val errorMessage: String) :
        NetworkResponse<Nothing>() // Error
}
