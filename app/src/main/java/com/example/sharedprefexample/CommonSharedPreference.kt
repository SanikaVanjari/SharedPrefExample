package com.example.sharedprefexample

import android.content.Context

object CommonSharedPreference {

    private const val KEY_BUTTON_CLICKED = "button_clicked"

    fun isButtonClicked(context: Context): Boolean?{
        return SharedPrefHelper.getBoolean(context, KEY_BUTTON_CLICKED,false)
    }

    fun setButtonClicked(context: Context,value:Boolean) {
        SharedPrefHelper.setBoolean(context, KEY_BUTTON_CLICKED,value)
    }
}