package com.example.brainviredemo.retrofit.response

import com.google.gson.annotations.SerializedName

data class MainListResponse(

	@field:SerializedName("end_at")
	val endAt: String? = null,

	@field:SerializedName("rates")
	val rates: LinkedHashMap<String, LinkedHashMap<String, Double>>? = null,

	@field:SerializedName("start_at")
	val startAt: String? = null,

	@field:SerializedName("base")
	val base: String? = null
)

