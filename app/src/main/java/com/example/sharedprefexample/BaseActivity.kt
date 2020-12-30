package com.example.sharedprefexample

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.jessyan.autosize.AutoSize
import me.jessyan.autosize.AutoSizeCompat

open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    override fun getResources(): Resources {
        var res=super.getResources()
        AutoSize.checkAndInit(application)
        AutoSizeCompat.autoConvertDensityOfGlobal(res)
        return res
    }
}