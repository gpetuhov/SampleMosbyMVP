package com.gpetuhov.android.samplemosbymvp.presentation.presenter

import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.hannesdorfmann.mosby3.mvp.MvpPresenter

// Here we declare methods that get called on user interactions
interface MainPresenter : MvpPresenter<MainView> {
    fun loadGreeting()
}
