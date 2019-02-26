package com.gpetuhov.android.samplemosbymvp.presentation.presenter

import com.gpetuhov.android.samplemosbymvp.domain.interactor.GetGreetingInteractor
import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class MainPresenterImpl : MvpBasePresenter<MainView>(), MainPresenter {

    override fun loadGreeting() {
        // TODO: add RxJava

        val greeting = GetGreetingInteractor.getGreeting()

        ifViewAttached { view -> view.showGreeting(greeting.text) }
    }
}
