package com.gpetuhov.android.samplemosbymvp.presentation.presenter

import com.gpetuhov.android.samplemosbymvp.domain.interactor.GetGreetingInteractor
import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

// Presenter is the mediator between business logic (interactors at domain layer) and the UI
class MainPresenterImpl : MvpBasePresenter<MainView>(), MainPresenter {

    override fun loadGreeting() {
        // TODO: add RxJava

        // Presenter interacts with interactors to trigger use cases
        val greeting = GetGreetingInteractor.getGreeting()

        // Update view with the results of the use case if view is attached
        ifViewAttached { view -> view.showGreeting(greeting.text) }
    }
}
