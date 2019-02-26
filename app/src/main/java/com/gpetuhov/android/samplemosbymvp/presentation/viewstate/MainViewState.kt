package com.gpetuhov.android.samplemosbymvp.presentation.viewstate

import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState

// ViewState keeps data for restoring views on orientation change
class MainViewState : ViewState<MainView> {
    companion object {
        private const val STATE_DO_NOTHING = 0
        private const val STATE_SHOW_DATA = 1
        private const val STATE_SHOW_LOADING = 2
        private const val STATE_SHOW_ERROR = 3
    }

    private var state = STATE_DO_NOTHING

    private var data: String? = null

    fun setData(data: String) {
        state = STATE_SHOW_DATA
        this.data = data
    }

    fun setShowLoading() {
        state = STATE_SHOW_LOADING
    }

    fun setShowError() {
        state = STATE_SHOW_ERROR
    }

    override fun apply(view: MainView, retained: Boolean) {
        when (state) {
            STATE_SHOW_DATA -> view.showGreeting(data!!)
            STATE_SHOW_LOADING -> view.showLoading()
            STATE_SHOW_ERROR -> data = null
        }
    }
}
