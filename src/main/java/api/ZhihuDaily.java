package api;

import model.StartImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface ZhihuDaily {

    /**
     * Get startup interface image
     *
     * @param size image size, see {@link model.ImageSize}
     * @return {@link StartImage}
     */
    @GET("start-image/{size}")
    Call<StartImage> getStartImage(@Path("size") String size) throws IOException;

}
