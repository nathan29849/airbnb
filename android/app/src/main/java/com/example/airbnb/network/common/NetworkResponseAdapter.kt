package com.example.airbnb.network.common

import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class NetworkResponseAdapter<T : Any>(private val successType: Type) : CallAdapter<T, Call<NetworkResponse<T>>> {
    override fun responseType(): Type {
        return successType
    }

    override fun adapt(call: Call<T>): Call<NetworkResponse<T>> {
        return NetworkResponseCall(call)
    }
}