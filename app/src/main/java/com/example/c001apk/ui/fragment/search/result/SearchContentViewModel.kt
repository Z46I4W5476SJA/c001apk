package com.example.c001apk.ui.fragment.search.result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.c001apk.logic.model.HomeFeedResponse
import com.example.c001apk.logic.network.Repository

class SearchContentViewModel : ViewModel() {

    var isInit = true
    val searchList = ArrayList<HomeFeedResponse.Data>()

    var isRefreshing = true
    var isLoadMore = false
    var isEnd = false

    var type: String = ""
    var feedType: String = "all"
    var sort: String = "default"
    var keyWord: String = ""
    var page = 1

    private val getSearchData = MutableLiveData<String>()

    val searchData = getSearchData.switchMap {
        Repository.getSearch(type, feedType, sort, keyWord, page)
    }

    fun getSearch() {
        getSearchData.value = getSearchData.value
    }

}