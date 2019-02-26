package com.gpetuhov.android.samplemosbymvp.domain.interactor

import com.gpetuhov.android.samplemosbymvp.domain.repository.Repository

// We have interactor for every use case (in this example, just this one)

// This should be injected
object GetGreetingInteractor {
    fun getGreeting() = Repository.getGreeting()
}