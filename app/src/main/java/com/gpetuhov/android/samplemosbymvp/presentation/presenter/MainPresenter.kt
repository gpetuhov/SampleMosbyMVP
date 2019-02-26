package com.gpetuhov.android.samplemosbymvp.presentation.presenter

import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.hannesdorfmann.mosby3.mvp.MvpPresenter

interface MainPresenter : MvpPresenter<MainView> {
    fun loadGreeting()
}
