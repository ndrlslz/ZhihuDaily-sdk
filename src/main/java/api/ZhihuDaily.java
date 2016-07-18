package api;

import model.DailyNews;
import model.News;
import model.StartImage;
import model.Version;
import retrofit2.http.GET;
import retrofit2.http.Path;
import service.ServiceCall;


/**
 * ZhihuDaily API
 *
 * @see <a href=
 * "https://github.com/izzyleung/ZhihuDailyPurify/wiki/%E7%9F%A5%E4%B9%8E%E6%97%A5%E6%8A%A5-API-%E5%88%86%E6%9E%90">
 * ZhihuDaily API</a>
 */
public interface ZhihuDaily {

    /**
     * Get startup interface image
     *
     * @param size image size, see {@link model.ImageSize}
     * @return {@link StartImage}
     */
    @GET("start-image/{size}")
    ServiceCall<StartImage> getStartImage(@Path("size") String size);

    /**
     * Get app version on android device
     *
     * @param currentVersion current version
     * @return {@link Version}
     */
    @GET("version/android/{version}")
    ServiceCall<Version> getVersionOfAndroid(@Path("version") String currentVersion);

    /**
     * Get app version on ios device
     *
     * @param currentVersion current version
     * @return {@link Version}
     */
    @GET("version/ios/{version}")
    ServiceCall<Version> getVersionOfIOS(@Path("version") String currentVersion);

    /**
     * Get latest news
     *
     * @return {@link DailyNews}
     */
    @GET("news/latest")
    ServiceCall<DailyNews> getLatestNews();

    /**
     * Get news
     *
     * @param id news id
     * @return {@link News}
     */
    @GET("news/{id}")
    ServiceCall<News> getNews(@Path("id") int id);


    @GET("news/before/{date}")
    ServiceCall<DailyNews> getBeforeNews(@Path("date") String date);
}
