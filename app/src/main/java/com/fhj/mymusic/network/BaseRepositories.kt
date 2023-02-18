package com.fhj.mymusic.network

/**
 *
 *
 * com.fhj.mymusic.network
 */
abstract class BaseRepositories {

    val retrofit by lazy {
        NetWorkHelper.createGsonRetrofit(getBaseUrl())
    }

    abstract fun getBaseUrl():String

    fun <T> createService(clazz: Class<T>):T{
        return retrofit.create(clazz)
    }

}