package com.gpetuhov.android.samplemosbymvp.domain.interactor

import com.gpetuhov.android.samplemosbymvp.domain.model.Greeting
import com.gpetuhov.android.samplemosbymvp.domain.repository.Repository
import io.reactivex.Single

// This is business logic (domain layer).
// Here we have interactor for every use case (in this example, just this one).

// This should be injected instead of being singleton
object GetGreetingInteractor {
    fun getGreeting(): Single<Greeting> = Repository.getGreeting()
}