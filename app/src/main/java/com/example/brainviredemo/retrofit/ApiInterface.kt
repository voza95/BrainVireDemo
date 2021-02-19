package com.example.brainviredemo.retrofit

import com.example.brainviredemo.retrofit.response.MainListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {

    @GET("history")
    fun getHistoryList(
        @Query("start_at") startAt:String,
        @Query("end_at") endAt:String,
        @Query("base") base:String?="USD"
    ): Call<MainListResponse>
}