package com.angle.kotlinupgradestu

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

/**
 *  作者    angle
 *  时间    2019-11-26 15:18
 *  文件    KotlinDemo
 *  描述
 */
open class PropertyChangeAware{
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener : PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}