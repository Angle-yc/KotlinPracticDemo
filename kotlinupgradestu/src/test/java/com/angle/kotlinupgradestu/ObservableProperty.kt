package com.angle.kotlinupgradestu

import java.beans.PropertyChangeSupport

/**
 *  作者    angle
 *  时间    2019-11-26 15:42
 *  文件    KotlinDemo
 *  描述
 */
class ObservableProperty(val propName: String,var propValue : Int,val changeSupport: PropertyChangeSupport) {
    fun getValue() : Int = propValue
    fun setValue(newValue : Int){
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(propName,oldValue,newValue)
    }
}
