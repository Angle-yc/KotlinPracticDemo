package com.angle.kotlindemo

import android.annotation.SuppressLint
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.angle.kotlindemo.bean.User
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class MainActivity : AppCompatActivity() {
    private var a: String = "不为空的字符串"
    private var b = a.length
    private var i: Int = 10
    private var setBook = setOf("first", "secode", "three")
    private var toast: Toast? = null
    private var callback: ((str: String) -> Unit)? = null
    private var management: FragmentManager? = null
    private var transaction: FragmentTransaction? = null
    private var user: User? = null

    @SuppressLint("SetTextI18n", "CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_text.text = "欢迎使用Kotlin，\n${getString("不为空返回")}\n$b"
        management = fragmentManager
        transaction = management?.beginTransaction()
        tv_text?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("kotlin", "我是从MainActivity过来的")
            startActivity(intent)
        }

        ifStatement()
        forLoop()
        userIt()
        jumpForLoop()
        callBackUser()
        listForEach()
        userClass()
        judge()
        filter()

    }



    /**
     * it 表示setBook的泛型
     */
    private fun userIt(){
        setBook.forEach {
            print(it)
            toast= Toast.makeText(this,it,Toast.LENGTH_SHORT)
            toast?.show()
        }
        setBook.forEach(::println)
    }
    /**
     * 跳出外层For循环
     */
    private fun jumpForLoop(){
        angle@for (itemA in 1..4){
            for (itemB in (1..4)){
                if (itemB>2){
                    break@angle
                }
                println("$itemA:$itemB")
            }
        }
    }

    /**
     * 集合过滤练习
     */
    private fun filter(){
        val userList = getUserList().filter { it.age == 3 }
        userList.forEach { println(it.name) }
    }

    /**
     * 得到一个泛型User的List
     */
    private fun getUserList(): ArrayList<User> {
        val userList = ArrayList<User>()
        for (i in 1..9) {
            val user = User("大黄"+(i+1), i + 1)
            userList.add(user)
        }
        return userList
    }

    private fun callBackUser() {
        callback = { Toast.makeText(this, it, Toast.LENGTH_SHORT).show() }
        callback = { println(it) }
        callback = { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
        callback?.invoke("hello")
    }

    private fun listForEach() {
        /**
         * 集合添加遍历
         */
        val list = ArrayList<String>()
        for (i in 1..10) {
            list.add("第$i" + "条数据")
        }
//        var length:Int=list.size
//        for (i in 0 until length){
//            Log.d("集合：",list.get(i))
//        }
        list.forEach { Log.d("集合：", it) }
    }

    /**
     * 类的使用和建立
     */
    private fun userClass() {
        user = User()
        user = User("小明")
        user = User("校花", 10)
//        Toast.makeText(this,user?.name+"今年"+user?.age+"岁了",Toast.LENGTH_SHORT).show()
        Toast.makeText(this, "${maxof(8, 10)}", Toast.LENGTH_SHORT).show()
    }

    /**
     * 好像他娘的 "=="和"==="没什么区别
     */
    private fun judge() {
        val a = 38
        val b = 38
        //判断值相等
        println(a == b)
        //判断值和引用都要相等
        println(a === b)
    }


    /**
     * 返回非空字符串的方法
     */
    private fun getString(text: String?): String {
        if (text == null) {
            return "为空返回"
        }
        return text
    }

    /**
     * if语句
     */
    private fun ifStatement() {
        if (i in 1..10)
            println("if语句:  $i")
    }

    /**
     * for循环
     *  until 包前不包后 [)
     *  ..   都包括 []
     *  down To  倒序
     *  step 指定步长
     *
     */
    private fun forLoop() {
//        for (i in 1..4) {
//            println("for循环:  $i")
//        }
//        for (i in 1 until 4) {
//            println("for循环:  $i")
//        }
//        for (i in 4 downTo 1) {
//            println("for循环:  $i")
//        }
        for (i in 1..10 step 2) {
            println("for循环:  $i")
        }
    }

    private fun maxof(a: Int, b: Int) = if (a > b) a else b
}

