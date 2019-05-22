package com.theapache64.removebgexample

import android.app.Application
import com.theapache64.removebg.RemoveBg

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        RemoveBg.init("H55t75AyMQF2FkGgsX6Mzb1g")
    }
}