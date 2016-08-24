import me.ndrlslz.api.ZhihuDaily;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import me.ndrlslz.deserializer.CommentsDeserializer;
import me.ndrlslz.deserializer.DateTypeAdapter;
import me.ndrlslz.exception.HttpException;
import me.ndrlslz.ZhihuDailyClient;
import me.ndrlslz.model.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import me.ndrlslz.service.ServiceCallback;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ZhihuDailyMockTest {
    private static Gson gson;
    private static MockWebServer server = new MockWebServer();
    private static ZhihuDaily zhihuDaily;
    private static final Type COMMENTS = new TypeToken<List<Comment>>() {
    }.getType();

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(COMMENTS, new CommentsDeserializer())
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();
    }

    @Before
    public void setUp() throws IOException {
        zhihuDaily = ZhihuDailyClient.create(server.url("/").toString());
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
    public void testGetStartImageWithException() throws IOException, InterruptedException {
        mockServerWith404();

        BlockingQueue<Object> blockingQueue = new ArrayBlockingQueue<>(10);
        zhihuDaily.getStartImage(ImageSize.SIZE_1080P).enqueue(new ServiceCallback<StartImage>() {
            @Override
            public void onResponse(StartImage object) {
                blockingQueue.add(object);
            }

            @Override
            public void onFailure(HttpException exception) {
                blockingQueue.add(exception);
            }
        });

        Object o = blockingQueue.take();
        assertTrue(o instanceof HttpException);
        HttpException httpException = (HttpException) o;
        assertNotNull(httpException.getCode());
        assertNotNull(httpException.getMessage());
        assertNotNull(httpException.getResponse());
    }

    @Test
    public void testGetVersionOfAndroid() throws IOException {
        Version response = new Version();
        response.setLatest("2.6.0");
        response.setStatus(1);
        response.setMsg("test-msg");
        response.setUrl("test-url");

        mockServerWith(response);

        Version version = zhihuDaily.getVersionOfAndroid("2.3.0").execute();
        assertNotNull(version);
        assertEquals(version.getLatest(), response.getLatest());
        assertEquals(version.getStatus(), response.getStatus());
        assertEquals(version.getMsg(), response.getMsg());
        assertEquals(version.getUrl(), response.getUrl());
    }

    @Test
    public void testGetVersionOfIOS() throws IOException {
        Version response = new Version();
        response.setLatest("2.6.0");
        response.setStatus(1);
        response.setMsg("test-msg");
        response.setUrl("test-url");

        mockServerWith(response);

        Version version = zhihuDaily.getVersionOfIOS("2.3.0").execute();
        assertNotNull(version);
        assertEquals(version.getLatest(), response.getLatest());
        assertEquals(version.getStatus(), response.getStatus());
        assertEquals(version.getMsg(), response.getMsg());
        assertEquals(version.getUrl(), response.getUrl());
    }

    @Test
    public void testGetLatestNews() throws IOException {
        DailyNews response = new DailyNews();
        response.setDate("20160713");
        response.setStories(Collections.singletonList(new Story()));
        TopStory topStory = new TopStory();
        topStory.setId(1);
        topStory.setGa_prefix("test-ga");
        topStory.setImage("test-image");
        topStory.setTitle("test-title");
        topStory.setType(1);
        response.setTop_stories(Collections.singletonList(topStory));

        mockServerWith(response);

        DailyNews latestNews = zhihuDaily.getLatestNews().execute();
        assertNotNull(latestNews);
        assertNotNull(latestNews.getStories());
        assertTrue(latestNews.getStories().size() > 0);
        assertNotNull(latestNews.getTop_stories());
        assertTrue(latestNews.getTop_stories().size() > 0);
        assertNotNull(latestNews.getTop_stories().get(0).getId());
        assertNotNull(latestNews.getTop_stories().get(0).getTitle());
        assertNotNull(latestNews.getTop_stories().get(0).getGa_prefix());
        assertNotNull(latestNews.getTop_stories().get(0).getImage());
        assertNotNull(latestNews.getTop_stories().get(0).getType());

    }

    @Test
    public void testGetNews() throws IOException {
        News response = new News();
        response.setId(1);
        response.setTitle("title");
        response.setBody("body");
        response.setType(0);
        response.setImages(Arrays.asList("image1", "image2"));
        response.setRecommenders(Collections.singletonList(new News.Recommender()));
        response.setImage("test-image");
        response.setGa_prefix("test-ga");
        response.setImage_source("test-image-source");
        response.setShare_url("test-url");
        response.setJs(Collections.singletonList(""));
        response.setCss(Collections.singletonList(""));
        News.Section section = new News.Section();
        section.setId(1);
        section.setName("test-name");
        section.setThumbnail("test-thumbnail");
        response.setSection(section);
        News.Recommender recommender = new News.Recommender();
        recommender.setAvatar("test-avatar");
        response.setRecommenders(Collections.singletonList(recommender));

        mockServerWith(response);

        News news = zhihuDaily.getNews(1).execute();
        assertNotNull(news);
        assertEquals(news.getTitle(), response.getTitle());
        assertEquals(news.getBody(), response.getBody());
        assertEquals(news.getType(), response.getType());
        assertEquals(news.getImage(), response.getImage());
        assertEquals(news.getGa_prefix(), response.getGa_prefix());
        assertEquals(news.getImage_source(), response.getImage_source());
        assertEquals(news.getShare_url(), response.getShare_url());
        assertNotNull(news.getJs());
        assertNotNull(news.getCss());
        assertNotNull(news.getImages());
        assertEquals(news.getSection().getId(), section.getId());
        assertEquals(news.getSection().getName(), section.getName());
        assertEquals(news.getSection().getThumbnail(), section.getThumbnail());
        assertNotNull(news.getRecommenders());
        assertEquals(news.getRecommenders().get(0).getAvatar(), recommender.getAvatar());
    }

    @Test
    public void testGetBeforeNews() throws IOException {
        final String date = "20160712";
        DailyNews response = new DailyNews();
        Story story = new Story();
        story.setId(1);
        story.setType(1);
        story.setTitle("title");
        story.setGa_prefix("test-ga");
        story.setImages(Collections.singletonList(""));
        response.setStories(Collections.singletonList(story));
        response.setDate(date);

        mockServerWith(response);

        DailyNews beforeNews = zhihuDaily.getBeforeNews(date).execute();

        assertNotNull(beforeNews);
        assertEquals(beforeNews.getDate(), response.getDate());
        Story expected = beforeNews.getStories().get(0);
        assertEquals(expected.getId(), story.getId());
        assertEquals(expected.getTitle(), story.getTitle());
        assertEquals(expected.getGa_prefix(), story.getGa_prefix());
        assertEquals(expected.getImages(), story.getImages());
        assertEquals(expected.getType(), story.getType());
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

        String json = "{\"comments\":" + gson.toJson(response) + "}";

        mockServerWith(json);

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
        response.add(comment);

        String json = "{\"comments\":" + gson.toJson(response) + "}";

        mockServerWith(json);

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
        themeSummary.setColor(1);

        Themes response = new Themes();
        response.setLimit(1000);
        response.setOthers(Collections.singletonList(themeSummary));
        response.setSubscribed(Collections.singletonList(""));

        mockServerWith(response);

        Themes themes = zhihuDaily.getThemes().execute();
        assertNotNull(themes);
        assertNotNull(themes.getLimit());
        assertNotNull(themes.getSubscribed());
        assertTrue(themes.getOthers().size() == 1);
        Themes.ThemeSummary expected = themes.getOthers().get(0);
        assertEquals(expected.getName(), themeSummary.getName());
        assertEquals(expected.getId(), themeSummary.getId());
        assertEquals(expected.getDescription(), themeSummary.getDescription());
        assertEquals(expected.getColor(), themeSummary.getColor());
        assertEquals(expected.getThumbnail(), themeSummary.getThumbnail());

    }

    @Test
    public void testGetTheme() throws IOException {
        Theme response = new Theme();
        response.setName("test-name");
        response.setStories(Collections.singletonList(new Story()));
        response.setDescription("test-description");
        response.setEditors(Collections.singletonList(new Editor()));
        response.setImage("test-image");
        response.setColor(1);
        response.setBackground("test-background");
        response.setImage_source("test-image-source");

        mockServerWith(response);

        Theme theme = zhihuDaily.getTheme(1).execute();

        assertNotNull(theme);
        assertEquals(theme.getName(), response.getName());
        assertEquals(theme.getDescription(), response.getDescription());
        assertEquals(theme.getColor(), response.getColor());
        assertEquals(theme.getBackground(), response.getBackground());
        assertEquals(theme.getImage(), response.getImage());
        assertEquals(theme.getImage_source(), response.getImage_source());
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

    @Test
    public void testGetRecommenders() throws IOException {
        Recommenders response = new Recommenders();
        Editor editor = new Editor();
        editor.setUrl("test-url");
        editor.setAvatar("test-avatar");
        editor.setBio("test-bio");
        editor.setId(1);
        editor.setName("test-name");
        response.setEditors(Collections.singletonList(editor));
        response.setItem_count(1);
        response.setItems(Collections.singletonList(""));

        mockServerWith(response);

        Recommenders recommenders = zhihuDaily.getRecommenders(1).execute();
        assertNotNull(recommenders);
        assertTrue(recommenders.getEditors().size() == 1);
        assertEquals(recommenders.getItem_count(), response.getItem_count());
        assertEquals(recommenders.getItems(), response.getItems());
        assertNotNull(recommenders.getItem_count());
        Editor expected = recommenders.getEditors().get(0);
        assertEquals(expected.getName(), editor.getName());
        assertEquals(expected.getId(), editor.getId());
        assertEquals(expected.getBio(), editor.getBio());
        assertEquals(expected.getUrl(), editor.getUrl());
        assertEquals(expected.getAvatar(), editor.getAvatar());
    }

    public static void mockServerWith(Object o) {
        server.enqueue(new MockResponse().setBody(gson.toJson(o)));
    }

    public static void mockServerWith(String json) {
        server.enqueue(new MockResponse().setBody(json));
    }

    public static void mockServerWith404() {
        server.enqueue(new MockResponse()
                .setResponseCode(404));
    }
}
