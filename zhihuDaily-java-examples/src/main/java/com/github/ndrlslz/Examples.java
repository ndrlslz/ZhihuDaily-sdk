package com.github.ndrlslz;

import com.github.ndrlslz.api.ZhihuDaily;
import com.github.ndrlslz.exception.HttpException;
import com.github.ndrlslz.model.*;
import com.github.ndrlslz.service.ServiceCallback;
import com.github.ndrlslz.utils.DateUtils;

import java.io.IOException;
import java.util.List;

public class Examples {
    public static void main(String[] args) throws IOException {
        ZhihuDaily zhihuDaily = ZhihuDailyClient.create();

        //Get latest news list.
        zhihuDaily.getLatestNews().enqueue(new ServiceCallback<DailyNews>() {
            @Override
            public void onResponse(DailyNews object) {
                object.getStories().forEach(System.out::println);
            }

            @Override
            public void onFailure(HttpException exception) {
                System.out.println(exception.getCode());
                System.out.println(exception.getMessage());
                System.out.println(exception.getResponse());
            }
        });


        //Get details of news by id.
        //First, get ID that you want to know.
        //Second, get details of news.
        int id = zhihuDaily.getLatestNews().execute().getStories().get(0).getId();

        zhihuDaily.getNews(id).enqueue(new ServiceCallback<News>() {
            @Override
            public void onResponse(News object) {
                System.out.println(object);
            }

            @Override
            public void onFailure(HttpException exception) {

            }
        });


        //Get news list of specified day.
        zhihuDaily.getBeforeNews(DateUtils.getStringWith(2016, 8, 15)).enqueue(new ServiceCallback<DailyNews>() {
            @Override
            public void onResponse(DailyNews object) {
                object.getStories().forEach(System.out::println);
            }

            @Override
            public void onFailure(HttpException exception) {
                System.out.println(exception.getCode());
            }
        });


        //Get extra information of news such as number of comments and number of popularity.
        zhihuDaily.getExtraInformation(id).enqueue(new ServiceCallback<ExtraInformation>() {
            @Override
            public void onResponse(ExtraInformation object) {
                System.out.println(object);
            }

            @Override
            public void onFailure(HttpException exception) {

            }
        });


        //Get information of short comments.
        zhihuDaily.getShortComments(id).enqueue(new ServiceCallback<List<Comment>>() {
            @Override
            public void onResponse(List<Comment> object) {
                object.forEach(System.out::println);
            }

            @Override
            public void onFailure(HttpException exception) {

            }
        });


        //Get themes of zhihu daily.
        zhihuDaily.getThemes().enqueue(new ServiceCallback<Themes>() {
            @Override
            public void onResponse(Themes object) {
                object.getOthers().forEach(System.out::println);
            }

            @Override
            public void onFailure(HttpException exception) {

            }
        });

        //Get content of theme by theme id.
        int themeId = zhihuDaily.getThemes().execute().getOthers().get(0).getId();

        zhihuDaily.getTheme(themeId).enqueue(new ServiceCallback<Theme>() {
            @Override
            public void onResponse(Theme object) {
                System.out.println(object);
            }

            @Override
            public void onFailure(HttpException exception) {

            }
        });

    }
}
