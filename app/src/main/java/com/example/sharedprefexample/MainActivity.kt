package com.example.sharedprefexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (VersionUtil.hasL()){
            Toast.makeText(this,"hasL() is true", Toast.LENGTH_LONG).show()
        }

        SharedPrefHelper.setString(this,"HOLA","hello world")

        val result =SharedPrefHelper.getString(this,"HOLA","")

        Log.d("MainActivity", "onCreate: $result")

        val button: Button= findViewById(R.id.button)
        button.setOnClickListener {
            CommonSharedPreference.setButtonClicked(this,true)
            val isClicked= CommonSharedPreference.isButtonClicked(this)
            Toast.makeText(this,"isClicked $isClicked", Toast.LENGTH_LONG).show()
        }
    }
}