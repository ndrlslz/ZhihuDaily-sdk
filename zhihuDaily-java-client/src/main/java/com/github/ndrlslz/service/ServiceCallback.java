package com.github.ndrlslz.service;

import com.github.ndrlslz.exception.HttpException;
import retrofit2.Response;

/**
 * Service Callback
 *
 * @param <T> Successful response body type.
 */
public interface ServiceCallback<T> {
    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     */
    void onResponse(T object);

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    void onFailure(HttpException exception);
}
