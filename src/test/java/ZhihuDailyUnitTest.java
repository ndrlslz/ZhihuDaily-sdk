import api.ZhihuDaily;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ZhihuDailyUnitTest {
    private ZhihuDaily zhihuDaily;

    static {
        ZhihuDailyClient.destory();
    }

    @Before
    public void setUp() {
        zhihuDaily = ZhihuDailyClient.create();
    }

    @Test
    public void testGetStartImage() throws IOException {
        StartImage startImage = zhihuDaily.getStartImage(ImageSize.SIZE_1080P).execute();

        assertNotNull(startImage);
        assertNotNull(startImage.toString());
        assertNotNull(startImage.hashCode());
        assertNotNull(startImage.getImg());
        assertNotNull(startImage.getText());
    }

    @Test
    public void testGetVersionOfAndroid() throws IOException {
        final String currentVersion = "2.3.0";
        Version version = zhihuDaily.getVersionOfAndroid(currentVersion).execute();

        assertNotNull(version);
        assertNotNull(version.toString());
        assertNotNull(version.hashCode());
        assertNotNull(version.getLatest());
        assertNotNull(version.getStatus());
    }

    @Test
    public void testGetVersionOfIOS() throws IOException {
        final String currentVersion = "2.3.0";
        Version version = zhihuDaily.getVersionOfIOS(currentVersion).execute();

        assertNotNull(version);
        assertNotNull(version.toString());
        assertNotNull(version.hashCode());
        assertNotNull(version.getStatus());
        assertNotNull(version.getLatest());
    }

    @Test
    public void testGetLatestNews() throws IOException {
        DailyNews latestNews = zhihuDaily.getLatestNews().execute();

        assertNotNull(latestNews);
        assertNotNull(latestNews.toString());
        assertNotNull(latestNews.hashCode());
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
        assertNotNull(news.toString());
        assertNotNull(news.hashCode());
        assertNotNull(news.getId());
        assertNotNull(news.getTitle());
        assertNotNull(news.getBody());

    }

    @Test
    public void testGetBeforeNews() throws IOException {
        final String date = "20140606";
        DailyNews beforeNews = zhihuDaily.getBeforeNews(date).execute();

        assertNotNull(beforeNews);
        assertNotNull(beforeNews.toString());
        assertNotNull(beforeNews.hashCode());
        assertNotNull(beforeNews.getStories());
        assertTrue(beforeNews.getStories().size() > 0);
        assertNotNull(beforeNews.getStories().get(0).getId());
        assertNotNull(beforeNews.getStories().get(0).getTitle());
    }

    @Test
    public void testGetExtraInformation() throws IOException {
        final int id = zhihuDaily.getLatestNews().execute().getTop_stories().get(0).getId();
        ExtraInformation extraInformation = zhihuDaily.getExtraInformation(id).execute();

        assertNotNull(extraInformation);
        assertNotNull(extraInformation.toString());
        assertNotNull(extraInformation.hashCode());
        assertNotNull(extraInformation.getComments());
        assertNotNull(extraInformation.getLong_comments());
        assertNotNull(extraInformation.getPopularity());
        assertNotNull(extraInformation.getShort_comments());
    }

    @Test
    public void testGetLongComments() throws IOException {
        final int id = 8574873;
        List<Comment> comments = zhihuDaily.getLongComments(id).execute();

        assertNotNull(comments);
        assertNotNull(comments.toString());
        assertNotNull(comments.hashCode());
        assertTrue(comments.size() > 0);
        assertNotNull(comments.get(0));
        assertNotNull(comments.get(0).getId());
        assertNotNull(comments.get(0).getAuthor());
        assertNotNull(comments.get(0).getContent());
        assertNotNull(comments.get(0).getLikes());
    }

    @Test
    public void testGetShortComments() throws IOException {
        final int id = 8574873;

        List<Comment> comments = zhihuDaily.getShortComments(id).execute();

        assertNotNull(comments);
        assertNotNull(comments.toString());
        assertNotNull(comments.hashCode());
        assertTrue(comments.size() > 0);
        assertNotNull(comments.get(0));
        assertNotNull(comments.get(0).getId());
        assertNotNull(comments.get(0).getAuthor());
        assertNotNull(comments.get(0).getContent());
        assertNotNull(comments.get(0).getLikes());
    }

    @Test
    public void testGetThemes() throws IOException {
        Themes themes = zhihuDaily.getThemes().execute();

        assertNotNull(themes);
        assertNotNull(themes.toString());
        assertNotNull(themes.hashCode());
        assertNotNull(themes.getOthers());
        assertNotNull(themes.getLimit());
        assertTrue(themes.getOthers().size() > 0);
        assertNotNull(themes.getOthers().get(0).getId());
        assertNotNull(themes.getOthers().get(0).getName());
    }

    @Test
    public void testGetTheme() throws IOException {
        final int id = zhihuDaily.getThemes().execute().getOthers().get(0).getId();
        Theme theme = zhihuDaily.getTheme(id).execute();

        assertNotNull(theme);
        assertNotNull(theme.toString());
        assertNotNull(theme.hashCode());
        assertNotNull(theme.getName());
        assertNotNull(theme.getEditors());
        assertTrue(theme.getEditors().size() > 0);
        assertNotNull(theme.getStories());
        assertTrue(theme.getStories().size() > 0);
    }

    @Test
    public void testGetHotNews() throws IOException {
        HotNews hotNews = zhihuDaily.getHotNews().execute();

        assertNotNull(hotNews);
        assertNotNull(hotNews.toString());
        assertNotNull(hotNews.hashCode());
        assertNotNull(hotNews.getRecent());
        assertTrue(hotNews.getRecent().size() > 0);

        HotNews.HotNewsInfo hotNewsInfo = hotNews.getRecent().get(0);
        assertNotNull(hotNewsInfo.getNews_id());
        assertNotNull(hotNewsInfo.getUrl());
        assertNotNull(hotNewsInfo.getTitle());
    }

    @Test
    public void testGetRecommenders() throws IOException {
        final int id = 7101963;
        Recommenders recommenders = zhihuDaily.getRecommenders(id).execute();

        assertNotNull(recommenders);
        assertNotNull(recommenders.toString());
        assertNotNull(recommenders.hashCode());
        assertNotNull(recommenders.getEditors());
        assertNotNull(recommenders.getEditors().get(0).getId());
        assertNotNull(recommenders.getEditors().get(0).getName());
    }
}
