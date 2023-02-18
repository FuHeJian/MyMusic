package com.fhj.mymusic.network

import com.fhj.mymusic.pojo.SongsJsonData
import com.google.gson.Gson

/**
 *
 *
 * com.fhj.mymusic.network
 */
object GsonUtil {

    fun getSongsItemList(src:String)=
        Gson().fromJson(src,SongsJsonData::class.java).songList

}