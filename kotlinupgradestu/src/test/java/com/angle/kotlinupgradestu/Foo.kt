package com.angle.kotlinupgradestu

/**
 * 作者    angle
 * 时间    2019-11-26 14:42
 * 文件    KotlinDemo
 * 描述
 */
class Foo(val name : String,  age : Int,  salary : Int) : PropertyChangeAware(){

    private val _age = ObservableProperty("age",age,changeSupport);

    var age : Int
        get() = _age.getValue()
        set(value) { _age.setValue(value) }

    val _salary = ObservableProperty("salary",salary,changeSupport)
    var salary : Int
        get() = _salary.getValue()
        set(value) { _salary.setValue(value) }

}