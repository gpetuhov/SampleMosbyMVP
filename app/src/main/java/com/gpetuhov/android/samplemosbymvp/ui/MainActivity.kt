package com.gpetuhov.android.samplemosbymvp.ui

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.gpetuhov.android.samplemosbymvp.R
import com.gpetuhov.android.samplemosbymvp.presentation.presenter.MainPresenter
import com.gpetuhov.android.samplemosbymvp.presentation.presenter.MainPresenterImpl
import com.gpetuhov.android.samplemosbymvp.presentation.view.MainView
import com.gpetuhov.android.samplemosbymvp.presentation.viewstate.MainViewState
import com.hannesdorfmann.mosby3.mvp.viewstate.MvpViewStateActivity

class MainActivity : MvpViewStateActivity<MainView, MainPresenter, MainViewState>(), MainView {

    lateinit var greetingTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        greetingTextView = findViewById(R.id.greeting_text)

        greetingTextView.setOnClickListener { presenter.loadGreeting() }
    }

    override fun onNewViewStateInstance() {
        // Do nothing
    }

    override fun createViewState() = MainViewState()

    override fun createPresenter() = MainPresenterImpl()

    override fun showGreeting(greetingText: String) {
//        viewState.setData(greetingText)
        greetingTextView.visibility = View.VISIBLE
        greetingTextView.text = greetingText
    }

    override fun showLoading() {
//        viewState.setShowLoading()
        greetingTextView.visibility = View.GONE
    }

    override fun hideLoading() {
        // TODO
    }

    override fun showError() {
//        viewState.setShowError()
        Toast.makeText(applicationContext, "Error loading greeting", Toast.LENGTH_LONG).show()
    }
}
