package com.angle.hshb.kotlindemo;

import android.content.Context
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.angle.hshb.kotlindemo.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL

class SecondActivity : AppCompatActivity() {
    val url = "http://39.106.199.100/userGroup/api/getGroup?id=1037156916961878018"

    val dataList = arrayListOf(
            "第yi条数据",
            "第er条数据",
            "第san条数据",
            "第si条数据",
            "第wu条数据",
            "第liu条数据",
            "第qi条数据",
            "第ba条数据",
            "第jiu条数据",
            "第shi条数据"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        recyclerList.layoutManager = LinearLayoutManager(this)
        recyclerList.adapter = ListAdapter(dataList)

        requestData()
    }

    private fun requestData() {
        async(){
            val forecastJsonStr = URL(url).readText()
            uiThread {
                System.out.println(forecastJsonStr)
            }
        }
    }


    fun Context.toast(message: CharSequence,duration:Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,message,duration).show()
    }

}
