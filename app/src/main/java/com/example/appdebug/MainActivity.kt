package com.example.appdebug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var click = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLogListener()
    }

    private fun setLogListener(){
        bt_debug?.setOnClickListener{
            Log.d("click","Opa! cliquei no debug")
        }
        bt_error?.setOnClickListener {
            click++;
            Log.e("click","Opa! cliquei no error")
        }
        bt_info.setOnClickListener { Log.i("click","Opa! cliquei no info") }
        bt_warning.setOnClickListener { Log.w("click","Opa! cliquei no warning") }
        bt_verbose.setOnClickListener { Log.v("click","Opa! cliquei no verbose") }
    }
}