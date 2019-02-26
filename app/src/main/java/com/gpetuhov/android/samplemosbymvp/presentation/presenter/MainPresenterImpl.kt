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
        // Presenter interacts with interactors to trigger use cases
        // and updates view if the view is attached.
        // Here interactor gets called on background thread
        // (because it has a delay that mimics database latency).
        disposables.add(
            GetGreetingInteractor.getGreeting()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // Gets called at the beginning
                .doOnSubscribe { ifViewAttached { view ->  view.showLoading() } }
                // Gets called after onSuccess or onError
                .doFinally { ifViewAttached { view ->  view.hideLoading() } }
                .subscribe(
                    // onSuccess
                    { ifViewAttached { view -> view.showGreeting(it.text) } },
                    // onError
                    { ifViewAttached { view ->  view.showError() } }
                )
        )
    }

    override fun destroy() {
        super.destroy()
        disposables.clear()
    }
}
