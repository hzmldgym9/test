package com.example.mytest

import android.app.Application
import android.os.Build
import com.zuoyebang.iot.pad.launcher.matrix.initMatrix

/**
 * @Author : Gym
 * @Date : 2023/3/29 6:30 PM
 * @Description :
 */
class MyApplication : Application() {
    companion object {
        lateinit var instance: Application
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        initMatrix()

    }

}