package com.fhj.mymusic.network.service

import com.fhj.mymusic.pojo.SongsJsonData
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

/**
 *
 *
 * com.fhj.mymusic.network.service
 */
interface RankingService {


    @Headers("Host: gateway.kugou.com",
            "kg-tid: 369",
            "kg-thash: 51c09dd",

            "user-agent: Android712-AndroidPhone-11509-201-0-NewRankSongListProtocol-wifi",
            "kg-rc: 1",
            "kg-fake: 0",
            "kg-rf: 0094decd" ,

            )
    @POST("/openapi/kmr/v2/rank/audio?dfid=3eS4XV1Jfet00nps8p4esdKB&clientver=11509&mid=150887615657541670365816093296416772138&signature=5d419cc76e40e5191004f4277f3220fa&clienttime=1676371457&uuid=5e70f136417bfe627b65e1a63b95cabe&appid=1005")
    suspend fun getRanking(@Body body:Map<String,String>):ResponseBody
}