import api.ZhihuDaily;
import com.google.gson.Gson;
import model.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.ServiceCallAdapterFactory;

import java.io.IOException;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ZhihuDailyMockTest {
    private static Gson gson = new Gson();
    private static MockWebServer server = new MockWebServer();
    private static ZhihuDaily zhihuDaily;

    static {
        zhihuDaily = new Retrofit.Builder()
                .baseUrl(server.url("/").toString())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ServiceCallAdapterFactory.create())
                .build()
                .create(ZhihuDaily.class);
    }

    @Before
    public void setUp() throws IOException {
    }

    @Test
    public void testGetStartImage() throws IOException {
        StartImage response = new StartImage();
        response.setImg("https://pic2.zhimg.com/17fb71ff2026d3ec9e1e096533a9f884.jpg");
        response.setText("Ian Schneider");

        mockServerWith(response);

        StartImage startImage = zhihuDaily.getStartImage(ImageSize.SIZE_1080P).execute();
        assertNotNull(startImage);
        assertEquals(startImage.getImg(), response.getImg());
        assertEquals(startImage.getText(), response.getText());
    }

    @Test
    public void testGetVersionOfAndroid() throws IOException {
        Version response = new Version();
        response.setLatest("2.6.0");
        response.setStatus(1);
        response.setMsg("test-msg");

        mockServerWith(response);

        Version version = zhihuDaily.getVersionOfAndroid("2.3.0").execute();
        assertNotNull(version);
        assertEquals(version.getLatest(), response.getLatest());
        assertEquals(version.getStatus(), response.getStatus());
        assertEquals(version.getMsg(), response.getMsg());
    }

    @Test
    public void testGetVersionOfIOS() throws IOException {
        Version response = new Version();
        response.setLatest("2.6.0");
        response.setStatus(1);
        response.setMsg("test-msg");

        mockServerWith(response);

        Version version = zhihuDaily.getVersionOfIOS("2.3.0").execute();
        assertNotNull(version);
        assertEquals(version.getLatest(), response.getLatest());
        assertEquals(version.getStatus(), response.getStatus());
        assertEquals(version.getMsg(), response.getMsg());
    }

    @Test
    public void testGetLatestNews() throws IOException {
        DailyNews response = new DailyNews();
        response.setDate("20160713");
        response.setStories(Collections.singletonList(new Story()));
        response.setTop_stories(Collections.singletonList(new TopStory()));

        mockServerWith(response);

        DailyNews latestNews = zhihuDaily.getLatestNews().execute();
        assertNotNull(latestNews);
        assertNotNull(latestNews.getStories());
        assertTrue(latestNews.getStories().size() > 0);
        assertNotNull(latestNews.getTop_stories());
        assertTrue(latestNews.getTop_stories().size() > 0);
    }

    @Test
    public void testGetNews() throws IOException {
        News response = new News();
        response.setId(1);
        response.setTitle("title");
        response.setBody("body");
        response.setType(0);
        response.setImages(Arrays.asList("image1", "image2"));
        response.setSection(new News.Section());
        response.setRecommenders(Collections.singletonList(new News.Recommender()));

        mockServerWith(response);

        News news = zhihuDaily.getNews(1).execute();
        assertNotNull(news);
        assertEquals(news.getTitle(), response.getTitle());
        assertEquals(news.getBody(), response.getBody());
        assertEquals(news.getSection(), response.getSection());
        assertEquals(news.getType(), response.getType());
        assertEquals(news.getRecommenders(), response.getRecommenders());
        assertEquals(news.getImages(), response.getImages());
    }

    @Test
    public void testGetBeforeNews() throws IOException {
        final String date = "20160712";
        DailyNews response = new DailyNews();
        Story story = new Story();
        story.setId(1);
        story.setType(1);
        story.setTitle("title");
        response.setStories(Collections.singletonList(story));
        response.setDate(date);

        mockServerWith(response);

        DailyNews beforeNews = zhihuDaily.getBeforeNews(date).execute();

        assertNotNull(beforeNews);
        assertEquals(beforeNews.getDate(), response.getDate());
        assertEquals(beforeNews.getStories(), response.getStories());

    }

    @Test
    public void testGetExtraInformation() throws IOException {
        ExtraInformation response = new ExtraInformation();
        response.setComments(100);
        response.setLong_comments(20);
        response.setPopularity(3);
        response.setShort_comments(10);

        mockServerWith(response);

        ExtraInformation extraInformation = zhihuDaily.getExtraInformation(1).execute();
        assertNotNull(extraInformation);
        assertEquals(extraInformation.getShort_comments(), response.getShort_comments());
        assertEquals(extraInformation.getPopularity(), response.getPopularity());
        assertEquals(extraInformation.getLong_comments(), response.getLong_comments());
        assertEquals(extraInformation.getComments(), response.getComments());

    }

    @Test
    public void testGetLongComments() throws IOException {
        List<Comment> response = new ArrayList<>();
        Comment comment = new Comment();
        comment.setAuthor("test-author");
        comment.setId(1);
        comment.setAvatar("address");
        comment.setLikes(0);
        comment.setContent("test-content");
        comment.setTime(new Date());
        response.add(comment);

        mockServerWith(response);

        List<Comment> longComments = zhihuDaily.getLongComments(1).execute();
        assertNotNull(longComments);
        assertTrue(longComments.size() == 1);
        assertEquals(longComments.get(0).getId(), comment.getId());
        assertEquals(longComments.get(0).getLikes(), comment.getLikes());
        assertEquals(longComments.get(0).getContent(), comment.getContent());
        assertEquals(longComments.get(0).getAuthor(), comment.getAuthor());
        assertEquals(longComments.get(0).getAvatar(), comment.getAvatar());
    }

    @Test
    public void testGetShortComments() throws IOException {
        List<Comment> response = new ArrayList<>();
        Comment comment = new Comment();
        comment.setAuthor("test-author");
        comment.setId(1);
        comment.setAvatar("address");
        comment.setLikes(0);
        comment.setContent("test-content");
        comment.setTime(new Date());
        response.add(comment);

        mockServerWith(response);

        List<Comment> shortComments = zhihuDaily.getShortComments(1).execute();
        assertNotNull(shortComments);
        assertTrue(shortComments.size() == 1);
        assertEquals(shortComments.get(0).getId(), comment.getId());
        assertEquals(shortComments.get(0).getLikes(), comment.getLikes());
        assertEquals(shortComments.get(0).getContent(), comment.getContent());
        assertEquals(shortComments.get(0).getAuthor(), comment.getAuthor());
        assertEquals(shortComments.get(0).getAvatar(), comment.getAvatar());
    }

    @Test
    public void testGetThemes() throws IOException {
        Themes.ThemeSummary themeSummary = new Themes.ThemeSummary();
        themeSummary.setColor(15007);
        themeSummary.setDescription("test-description");
        themeSummary.setId(1);
        themeSummary.setName("test-name");
        themeSummary.setThumbnail("test-thumbnail");

        Themes response = new Themes();
        response.setLimit(1000);
        response.setOthers(Collections.singletonList(themeSummary));

        mockServerWith(response);

        Themes themes = zhihuDaily.getThemes().execute();
        assertNotNull(themes);
        assertNotNull(themes.getLimit());
        assertTrue(themes.getOthers().size() == 1);
        assertEquals(themes.getOthers().get(0).getName(), themeSummary.getName());
        assertEquals(themes.getOthers().get(0).getId(), themeSummary.getId());
        assertEquals(themes.getOthers().get(0).getDescription(), themeSummary.getDescription());

    }

    @Test
    public void testGetTheme() throws IOException {
        Theme response = new Theme();
        response.setName("test-name");
        response.setStories(Collections.singletonList(new Story()));
        response.setDescription("test-description");
        response.setEditors(Collections.singletonList(new Editor()));
        response.setImage("test-image");

        mockServerWith(response);

        Theme theme = zhihuDaily.getTheme(1).execute();

        assertNotNull(theme);
        assertEquals(theme.getName(), response.getName());
        assertEquals(theme.getDescription(), response.getDescription());
        assertEquals(theme.getEditors(), response.getEditors());
        assertEquals(theme.getStories(), response.getStories());
    }

    @Test
    public void testGetHotNews() throws IOException {
        HotNews response = new HotNews();
        HotNews.HotNewsInfo hotNewsInfo = new HotNews.HotNewsInfo();
        hotNewsInfo.setThumbnail("test-thumbnail");
        hotNewsInfo.setNews_id(1);
        hotNewsInfo.setTitle("test-title");
        hotNewsInfo.setUrl("test-url");
        response.setRecent(Collections.singletonList(hotNewsInfo));

        mockServerWith(response);

        HotNews hotNews = zhihuDaily.getHotNews().execute();
        assertNotNull(hotNews);
        assertTrue(hotNews.getRecent().size() == 1);
        HotNews.HotNewsInfo expected = hotNews.getRecent().get(0);
        assertEquals(expected.getTitle(), hotNewsInfo.getTitle());
        assertEquals(expected.getUrl(), hotNewsInfo.getUrl());
        assertEquals(expected.getNews_id(), hotNewsInfo.getNews_id());
        assertEquals(expected.getThumbnail(), hotNewsInfo.getThumbnail());

    }

    public static void mockServerWith(Object o) {
        server.enqueue(new MockResponse().setBody(gson.toJson(o)));
    }

}
