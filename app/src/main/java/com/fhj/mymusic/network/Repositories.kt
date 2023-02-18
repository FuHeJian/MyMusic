package com.fhj.mymusic.network

import com.fhj.mymusic.network.service.RankingService
import com.fhj.mymusic.pojo.SongItem
import com.fhj.mymusic.pojo.SongsItemData
import com.google.gson.FieldNamingStrategy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.ToNumberPolicy
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.flow.*
import okhttp3.MediaType
import okhttp3.RequestBody
import okio.GzipSink
import okio.Utf8
import java.lang.reflect.Field
import java.util.Objects
import kotlin.coroutines.suspendCoroutine

/**
 *
 *
 * com.fhj.mymusic.network
 */
class Repositories(val coroutineScope: CoroutineScope) : BaseRepositories() {

    private val service by lazy {
        getAndCreateService()
    }

    override fun getBaseUrl() = "http://gateway.kugou.com"

    private var body = "{\"area_code\":\"1\",\"rank_id\":\"67093\",\"rank_cid\":67093,\"zone\":\"bj_kmr\",\"page\":1,\"pagesize\":100,\"show_portrait_mv\":1,\"filter_original_remarks\":1}"
    private val body2 = GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LAZILY_PARSED_NUMBER).create().fromJson<Map<String,String>>(body,Map::class.java)

    fun getRanking(callback:(list:List<SongItem>)->Unit) {
        coroutineScope.launch {
           flow {
                service.getRanking(body2).let {
                    emit(it)
                }
            }.collect{
                //处理数据
               callback(GsonUtil.getSongsItemList(it.string()))
           }
        }

    }

    private fun getAndCreateService() = retrofit.create(RankingService::class.java)

}