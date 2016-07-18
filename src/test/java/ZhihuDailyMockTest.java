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
import java.util.Arrays;
import java.util.Collections;

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

    public static void mockServerWith(Object o) {
        server.enqueue(new MockResponse().setBody(gson.toJson(o)));
    }

}
