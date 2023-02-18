package com.fhj.mymusic.viewmodel

import androidx.lifecycle.viewModelScope
import com.fhj.mymusic.network.Repositories

/**
 *
 *
 * com.fhj.mymusic.viewmodel
 */
class SquareViewModel:BaseViewModel() {

    private val repositories = Repositories(viewModelScope)

    fun getRanking()
    {
        repositories.getRanking{

        }
    }

}