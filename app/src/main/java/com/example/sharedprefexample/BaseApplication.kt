package com.example.sharedprefexample

import android.app.Application
import android.content.res.Resources
import me.jessyan.autosize.AutoSize
import me.jessyan.autosize.AutoSizeConfig

open class BaseApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        AutoSize.checkAndInit(
            this
        )
        AutoSizeConfig.getInstance()
            .setExcludeFontScale(true)
            .setBaseOnWidth(true)
            .setDesignHeightInDp(360)
            .setLog(true)
    }
}