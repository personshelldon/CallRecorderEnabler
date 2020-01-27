package com.don11995.oneplus.callrecorder.utils

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

fun <T> LiveData<T>.listen(owner: LifecycleOwner, observer: (T) -> Unit) {
    observe(owner, Observer(observer))
}
