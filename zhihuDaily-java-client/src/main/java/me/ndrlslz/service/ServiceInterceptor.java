package me.ndrlslz.service;

import me.ndrlslz.exception.HttpException;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ServiceInterceptor implements Interceptor {
    private static final Logger logger = LoggerFactory.getLogger(ServiceInterceptor.class);

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().build();

        logger.debug("Request url: " + request.url().toString());
        logger.debug("Request method: " + request.method());
        logger.debug("Request body: " + request.body());

        Response response = chain.proceed(request);
        if (response.isSuccessful()) {
            logger.debug("Request success");
        } else {
            logger.error("Request fail");
            throw new HttpException(response);
        }
        return response;
    }
}
