package com.angle.hshb.kotlindemo.bean

/**
 * Created by Administrator on 2017/8/17.
 */
class User{
    var name:String?=null
    var age:Int=0
    constructor()
    constructor(name: String){
        this.name=name
    }
    constructor(name: String,age:Int){
        this.name=name
        this.age=age
    }

}