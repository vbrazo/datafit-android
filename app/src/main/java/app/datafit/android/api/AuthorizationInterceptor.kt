package app.datafit.android.api

import app.datafit.android.App
import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor: Interceptor {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()

        if (App.getToken().isBlank()) return chain.proceed(originalRequest)

        val new = originalRequest.newBuilder()
            .addHeader("Authorization", App.getToken())
            .build()

        return chain.proceed(new)
    }
}
