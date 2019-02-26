package com.gpetuhov.android.samplemosbymvp.presentation.presenter

import com.gpetuhov.android.samplemosbymvp.domain.interactor.GetGreetingInteractor
import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

// Presenter is the mediator between business logic (interactors at domain layer) and the UI
class MainPresenterImpl : MvpBasePresenter<MainView>(), MainPresenter {

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun loadGreeting() {
//        // Presenter interacts with interactors to trigger use cases
//        val greeting = GetGreetingInteractor.getGreeting()
//
//        // Update view with the results of the use case if view is attached
//        ifViewAttached { view -> view.showGreeting(greeting.text) }

        disposables.add(
            GetGreetingInteractor.getGreeting()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { ifViewAttached { view ->  view.showLoading() } }
                .doFinally { ifViewAttached { view ->  view.hideLoading() } }
                .subscribe(
                    { ifViewAttached { view -> view.showGreeting(it.text) } },
                    { ifViewAttached { view ->  view.showError() } }
                )
        )
    }

    override fun destroy() {
        super.destroy()
        disposables.clear()
    }
}
