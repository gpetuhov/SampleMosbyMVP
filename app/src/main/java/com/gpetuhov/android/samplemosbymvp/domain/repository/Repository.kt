package com.gpetuhov.android.samplemosbymvp.domain.repository

import com.gpetuhov.android.samplemosbymvp.domain.model.Greeting

// Here we have a singleton. In real app Repository should be injected

// Repository keeps data (in this example just returns Greeting)
object Repository {

    // TODO: add RxJava with delay
    fun getGreeting() = Greeting("Hello!!!")
}