package com.example.sharedprefexample

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.tencent.mmkv.MMKV
import com.tencent.mmkv.MMKVHandler
import com.tencent.mmkv.MMKVLogLevel
import com.tencent.mmkv.MMKVRecoverStrategic

object SharedPrefHelper {
    private var INITED = false

    private var recoverHandler: MMKVHandler = object : MMKVHandler {
        override fun onMMKVCRCCheckFail(p0: String?): MMKVRecoverStrategic {
            return MMKVRecoverStrategic.OnErrorRecover
        }

        override fun onMMKVFileLengthError(p0: String?): MMKVRecoverStrategic {
            return MMKVRecoverStrategic.OnErrorRecover
        }

        override fun wantLogRedirecting(): Boolean {
            return false
        }

        override fun mmkvLog(p0: MMKVLogLevel?, p1: String?, p2: Int, p3: String?, p4: String?) {
            // do nothing
        }

    }

    private fun getSharedPreference(context: Context?): SharedPreferences {
        if (!INITED && (!TextUtils.isEmpty(MMKV.initialize(context)))) {
            INITED = true
        }
        MMKV.registerHandler(recoverHandler)
        return MMKV.defaultMMKV(MMKV.MULTI_PROCESS_MODE, null)!!
    }

    fun setString(context: Context?, key: String?, value: String?) {
        val editor: SharedPreferences.Editor = getSharedPreference(context).edit()
        if (value == null) {
            editor.remove(key).apply()
        } else {
            editor.putString(key, value).apply()
        }
    }

    fun getString(context: Context?, key: String?, defValue: String?): String? {
        val pref = getSharedPreference(context)
        return pref.getString(key, defValue)
    }

    fun getBoolean(context: Context, key: String, defValue:Boolean): Boolean? {
        val pref = getSharedPreference(context)
        return pref.getBoolean(key,defValue)
    }

    fun setBoolean(context: Context?,key: String?,value: Boolean?){
        val editor: SharedPreferences.Editor = getSharedPreference(context).edit()
        if (value == null) {
            editor.remove(key).apply()
        } else {
            editor.putBoolean(key, value).apply()
        }
    }
}

