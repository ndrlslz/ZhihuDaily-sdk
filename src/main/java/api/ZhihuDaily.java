package api;

import model.StartImage;
import model.Version;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ZhihuDaily {

    /**
     * Get startup interface image
     *
     * @param size image size, see {@link model.ImageSize}
     * @return {@link StartImage}
     */
    @GET("start-image/{size}")
    Call<StartImage> getStartImage(@Path("size") String size);

    /**
     * Get app version on android device
     *
     * @param currentVersion current version
     * @return {@link Version}
     */
    @GET("version/android/{version}")
    Call<Version> getVersionOfAndroid(@Path("version") String currentVersion);

    /**
     * Get app version on ios device
     *
     * @param currentVersion current version
     * @return {@link Version}
     */
    @GET("version/ios/{version}")
    Call<Version> getVersionOfIOS(@Path("version") String currentVersion);
}
