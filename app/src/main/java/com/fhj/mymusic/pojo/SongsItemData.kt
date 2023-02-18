package com.fhj.mymusic.pojo

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField

/**
 *
 *
 * com.fhj.mymusic.pojo
 */
//
class SongsItemData: BaseObservable() {

    val name = ObservableField<String>("hello")
    val age = "13"

}