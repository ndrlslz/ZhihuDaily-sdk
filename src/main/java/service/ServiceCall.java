package service;

import java.io.IOException;


/**
 * Service Call
 *
 * @param <T> Successful response body type.
 */
public interface ServiceCall<T> {
    /**
     * Synchronously send the request and return its response body.
     */
    T execute() throws IOException;

    /**
     * Asynchronously send the request and notify {@code callback} of its response or if an error
     * occurred talking to the server, creating the request, or processing the response.
     */
    void enqueue(ServiceCallback<T> callback);


    /**
     * Cancel this call. An attempt will be made to cancel in-flight calls, and if the call has not
     * yet been executed it never will be.
     */
    void cancel();

}

