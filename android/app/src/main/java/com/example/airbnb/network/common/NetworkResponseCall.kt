package com.example.airbnb.network.common

import okhttp3.Request
import okio.IOException
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkResponseCall<T : Any>(private val call: Call<T>) : Call<NetworkResponse<T>> {

    override fun enqueue(callback: Callback<NetworkResponse<T>>) {
        return call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()

                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Success(body))
                        )
                    } else {
                        // Response is successful but the body is null
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Error(ErrorType.NULL_BODY_ERROR, "데이터가 null 입니다."))
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            error
                        } catch (ex: Exception) {
                            null
                        }
                    }
                    if (errorBody != null) {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Error(ErrorType.API_ERROR,
                                "$code 코드 에러가 발생했습니다."
                            ))
                        )
                    } else {
                        callback.onResponse(
                            this@NetworkResponseCall,
                            Response.success(NetworkResponse.Error(ErrorType.UNKNOWN_ERROR, "알 수 없는 에러입니다."))
                        )
                    }
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                val networkResponse = when (t) {
                    is IOException -> NetworkResponse.Error(ErrorType.CONNECTION_ERROR, "네트워크 연결 오류가 발생하였습니다.")
                    else -> NetworkResponse.Error(ErrorType.UNKNOWN_ERROR, "알 수 없는 에러입니다.")
                }
                callback.onResponse(this@NetworkResponseCall, Response.success(networkResponse))
            }
        })
    }

    override fun clone(): Call<NetworkResponse<T>> = NetworkResponseCall(call.clone())


    override fun execute(): Response<NetworkResponse<T>> {
        throw UnsupportedOperationException("ResultCall doesn't support execute")
    }

    override fun isExecuted(): Boolean = call.isExecuted

    override fun cancel() = call.cancel()

    override fun isCanceled(): Boolean = call.isCanceled

    override fun request(): Request = call.request()

    override fun timeout(): Timeout = call.timeout()
}