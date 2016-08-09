package exception;

import okhttp3.Response;

import java.io.IOException;

public class HttpException extends IOException {
    private static final long serialVersionUID = -329939173791982572L;
    private final int code;
    private final String message;
    private final Response response;

    public HttpException(Response response) {
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "HttpException{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", response=" + response +
                '}';
    }
}
