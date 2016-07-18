import api.ZhihuDaily;
import model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ServiceCall;
import service.ServiceCallback;

import java.io.IOException;

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


        News news = zhihuDaily.getNews(latestNews.getTop_stories().get(0).getId()).execute();
        System.out.println(news);

        logger.debug("--------------------");

        DailyNews beforeNews = zhihuDaily.getBeforeNews("20140304").execute();
        beforeNews.getStories().forEach(System.out::println);
    }
}
