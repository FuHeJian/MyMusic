package com.fhj.mymusic.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 *
 *
 * com.fhj.mymusic.service
 */
class PlayService: Service() {

    override fun onCreate() {
        super.onCreate()
        println("hello world")
    }

    override fun onBind(intent: Intent?)=  null
}