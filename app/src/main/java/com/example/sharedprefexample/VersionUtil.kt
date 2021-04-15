package com.example.sharedprefexample

import android.os.Build

class VersionUtil {
    companion object{
        fun hasL(): Boolean{
            return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
        }
    }
}