package me.ndrlslz.api;

import me.ndrlslz.model.*;
import retrofit2.http.GET;
import retrofit2.http.Path;
import me.ndrlslz.service.ServiceCall;

import java.util.List;


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
     * @param size image size, see {@link me.ndrlslz.model.ImageSize}
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

    /**
     * Get before news by given data
     *
     * @param date date
     * @return {@link DailyNews}
     */
    @GET("news/before/{date}")
    ServiceCall<DailyNews> getBeforeNews(@Path("date") String date);

    /**
     * Get extra information of news
     *
     * @param id news id
     * @return {@link ExtraInformation}
     */
    @GET("story-extra/{id}")
    ServiceCall<ExtraInformation> getExtraInformation(@Path("id") int id);

    /**
     * Get long comments of news
     *
     * @param id news id
     * @return list of {@link Comment}
     */
    @GET("story/{id}/long-comments")
    ServiceCall<List<Comment>> getLongComments(@Path("id") int id);

    /**
     * Get short comments of news
     *
     * @param id news id
     * @return list of {@link Comment}
     */
    @GET("story/{id}/short-comments")
    ServiceCall<List<Comment>> getShortComments(@Path("id") int id);

    /**
     * Get themes
     *
     * @return {@link Themes}
     */
    @GET("themes")
    ServiceCall<Themes> getThemes();

    /**
     * Get theme
     *
     * @param id theme id
     * @return {@link Theme}
     */
    @GET("theme/{id}")
    ServiceCall<Theme> getTheme(@Path("id") int id);

    /**
     * Get hot news
     *
     * @return {@link HotNews}
     */
    @GET("news/hot")
    ServiceCall<HotNews> getHotNews();

    /**
     * Get news recommenders
     *
     * @param id news id
     * @return {@link Recommenders}
     */
    @GET("story/{id}/recommenders")
    ServiceCall<Recommenders> getRecommenders(@Path("id") int id);
}
