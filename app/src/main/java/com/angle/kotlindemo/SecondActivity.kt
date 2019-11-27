package com.angle.kotlindemo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.angle.kotlindemo.adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_second.*
import org.jetbrains.anko.async
import org.jetbrains.anko.uiThread
import java.net.URL
import java.sql.DriverManager.println
import java.util.ArrayList

class SecondActivity : AppCompatActivity() {
    private val url = "http://39.106.199.100/userGroup/api/getGroup?id=1037156916961878018"

    private val dataList = listOf(
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
        recyclerList.layoutManager = LinearLayoutManager(this) as RecyclerView.LayoutManager?
        recyclerList.adapter = ListAdapter(dataList)

        requestData()
    }

    private fun requestData() {
        async{
            val forecastJsonStr = URL(url).readText(charset("UTF-8"))
            uiThread {
                println(forecastJsonStr)
            }
        }
    }


}
