package com.example.appdebug

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class MainActivity : AppCompatActivity() {
    private var click = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setLogListener()
        val currentThread = Thread.currentThread()
        currentThread.setUncaughtExceptionHandler { t, e ->
            val x = e.message
            val cause = e.cause
        }
    }

    private fun setLogListener(){
        bt_debug?.setOnClickListener{
            Log.d("click","Opa! cliquei no debug")
        }
        bt_error?.setOnClickListener {
            var message:String = ""
//            click++;
//            Log.e("click","Opa! Houve $click clique no botão.")
            try {

                val list = listOf<Int>(2,4,6)
                val a = list[6]
                message = "Entrou no try"
            } catch (e: IndexOutOfBoundsException){
                message = "Entrou no catch certo"
            } catch (i: NullPointerException){
                message = "Entrou no catch errado"
            }finally {
                input_debug?.setText(message)
                val x = 35
            }
        }
        bt_info.setOnClickListener { Log.i("click","Opa! cliquei no info") }
        bt_warning.setOnClickListener { Log.w("click","Opa! cliquei no warning") }
        bt_verbose.setOnClickListener { Log.v("click","Opa! cliquei no verbose") }
    }
}