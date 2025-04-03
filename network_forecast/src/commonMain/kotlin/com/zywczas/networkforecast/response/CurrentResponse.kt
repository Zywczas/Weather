package com.zywczas.networkforecast.response

data class CurrentResponse(
//todo update to KMM
//    @SerializedName("temp")
    val temperature: Double = 0.0,

//    @SerializedName("humidity")
    val humidityPercentage: Int = 0,

//    @SerializedName("clouds")
    val cloudsPercentage: Int = 0,

//    @SerializedName("rain")
    val rain: PrecipitationResponse? = null,

//    @SerializedName("snow")
    val snow: PrecipitationResponse? = null,

//    @SerializedName("weather")
    val weather: List<WeatherResponse> = emptyList(),

//    @SerializedName("pressure")
    val pressure: Int = 0,

//    @SerializedName("visibility")
    val visibility: Int = 0,

//    @SerializedName("wind_speed")
    val windSpeed: Double = 0.0,
)
