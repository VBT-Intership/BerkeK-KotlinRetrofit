package berke.com.kotlinretrofitsample.service

import berke.com.kotlinretrofitsample.model.EarthquakeModel
import retrofit2.http.GET

interface EarthquakeApi {
    @GET("api")
    suspend fun getAllEarthquakes(): EarthquakeModel
}