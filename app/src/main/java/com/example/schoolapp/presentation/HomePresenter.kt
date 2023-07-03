package com.example.schoolapp.presentation

import android.os.Handler
import android.os.Looper
import com.example.schoolapp.model.HomeItem
import com.example.schoolapp.view.HomeFragment
import com.example.schoolapp.view.HomePage

class HomePresenter(
    private val view: HomeFragment,
) {
    fun findAllNotes() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<HomeItem>) {
        view.showNotes(response)
    }

    fun onError(message:String) {
        view.showFailure(message)
    }

    fun onComplete() {
        view.hideProgress()
    }

    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                val response = arrayListOf(
                    HomeItem("Olá mundo", 0xffffffff),
                )

                onSuccess(response)
                onComplete()
            }, 2000
        )
    }
}