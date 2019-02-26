package com.gpetuhov.android.samplemosbymvp.presentation.view

import com.hannesdorfmann.mosby3.mvp.MvpView

// UI View (in this example - MainActivity) must implement this interface
interface MainView : MvpView {
    fun showLoading()
    fun hideLoading()
    fun showGreeting(greetingText: String)
    fun showError()
}
