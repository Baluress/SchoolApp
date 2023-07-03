package com.example.schoolapp.presentation


import android.os.Handler
import android.os.Looper
import com.example.schoolapp.InfoItem
import com.example.schoolapp.R
import com.example.schoolapp.view.InformationFragment

class InformationPresenter(
    private val view: InformationFragment
) {
    fun findAllInfo() {
        fakeRequest()
    }

    fun onSuccess(response: List<InfoItem>) {
        view.showInfo(response)
    }

    fun onError(message:String) {
        view.showFailure(message)

    }

    private fun fakeRequest() {
        Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                InfoItem(R.string.important_note_1),
                InfoItem(R.string.important_note_2)
            )

            onSuccess(response)

        }, 0
        )
    }
}