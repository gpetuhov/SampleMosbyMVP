package com.gpetuhov.android.samplemosbymvp.domain.repository

import com.gpetuhov.android.samplemosbymvp.domain.model.Greeting
import io.reactivex.Single
import java.util.concurrent.TimeUnit

// Here we have a singleton. In real app Repository should be injected

// Repository keeps data (in this example just returns Greeting)
object Repository {

    fun getGreeting(): Single<Greeting> {
        return Single
            .just(Greeting("Hello!!!"))
            .delay(5, TimeUnit.SECONDS)     // this is needed to mock database or network latency
    }
}