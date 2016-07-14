import api.ZhihuDaily;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class ZhihuDailyUnitTest {
    private ZhihuDaily zhihuDaily;

    @Before
    public void setUp() {
        zhihuDaily = ZhihuDailyClient.create();
    }

    @Test
    public void testGetStartImage() throws IOException {
        StartImage startImage = zhihuDaily.getStartImage(ImageSize.SIZE_1080P).execute();

        assertNotNull(startImage);
        assertNotNull(startImage.getImg());
        assertNotNull(startImage.getText());
    }

    @Test
    public void testGetVersionOfAndroid() throws IOException {
        final String currentVersion = "2.3.0";
        Version version = zhihuDaily.getVersionOfAndroid(currentVersion).execute();

        assertNotNull(version);
        assertNotNull(version.getLatest());
        assertNotNull(version.getStatus());
    }

    @Test
    public void testGetVersionOfIOS() throws IOException {
        final String currentVersion = "2.3.0";
        Version version = zhihuDaily.getVersionOfIOS(currentVersion).execute();

        assertNotNull(version);
        assertNotNull(version.getStatus());
        assertNotNull(version.getLatest());
    }

    @Test
    public void testGetLatestNews() throws IOException {
        LatestNews latestNews = zhihuDaily.getLatestNews().execute();

        assertNotNull(latestNews);
        assertNotNull(latestNews.getDate());
        assertNotNull(latestNews.getStories());
        assertTrue(latestNews.getStories().size() > 0);
        assertNotNull(latestNews.getStories().get(0).getId());
        assertNotNull(latestNews.getTop_stories());
        assertTrue(latestNews.getTop_stories().size() > 0);
        assertNotNull(latestNews.getTop_stories().get(0).getId());
    }

    @Test
    public void testGetNews() throws IOException {
        final int id = zhihuDaily.getLatestNews().execute().getTop_stories().get(0).getId();
        News news = zhihuDaily.getNews(id).execute();

        assertNotNull(news);
        assertNotNull(news.getId());
        assertNotNull(news.getTitle());
        assertNotNull(news.getBody());

    }

}
