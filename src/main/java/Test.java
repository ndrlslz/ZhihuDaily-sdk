import api.ZhihuDaily;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ServiceCall;
import service.ServiceCallback;
import utils.DateUtils;

import java.io.IOException;
import java.util.List;

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) throws IOException {
        ZhihuDaily zhihuDaily = ZhihuDailyClient.create();

        ServiceCall<StartImage> call = zhihuDaily.getStartImage(ImageSize.SIZE_1080P);
        StartImage startImage = call.execute();
        System.out.println(startImage);

        zhihuDaily.getStartImage(ImageSize.SIZE_1080P).enqueue(new ServiceCallback<StartImage>() {
            @Override
            public void onResponse(StartImage object) {
                System.out.println(object);
            }

            @Override
            public void onFailure(Throwable t) {
            }
        });


        Version version = zhihuDaily.getVersionOfAndroid("2.3.0").execute();
        System.out.println(version);

        Version iosVersion = zhihuDaily.getVersionOfIOS("2.5.0").execute();
        System.out.println(iosVersion);

        DailyNews latestNews = zhihuDaily.getLatestNews().execute();
        System.out.println(latestNews.getDate());

        latestNews.getStories().forEach(System.out::println);
        latestNews.getTop_stories().forEach(System.out::println);

        int id = latestNews.getTop_stories().get(0).getId();
        News news = zhihuDaily.getNews(id).execute();
        System.out.println(news);

        logger.debug("--------------------");

        String now = DateUtils.getStringOfNow();
        String yesterday = DateUtils.getDayBefore(now);
        String beforeYesterday = DateUtils.getDayBefore(yesterday);

        DailyNews beforeNews = zhihuDaily.getBeforeNews(beforeYesterday).execute();
        beforeNews.getStories().forEach(System.out::println);


        ExtraInformation extraInformation = zhihuDaily.getExtraInformation(id).execute();
        System.out.println(extraInformation);


        List<Comment> comments = zhihuDaily.getLongComments(8574873).execute();
        comments.forEach(System.out::println);

        List<Comment> shortComments = zhihuDaily.getShortComments(id).execute();
        shortComments.forEach(System.out::println);


        Themes themes = zhihuDaily.getThemes().execute();
        System.out.println(themes.getLimit());
        System.out.println(themes.getSubscribed());
        themes.getOthers().forEach(System.out::println);

    }
}
