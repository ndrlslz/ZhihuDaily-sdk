import api.ZhihuDaily;
import com.google.gson.Gson;
import model.ImageSize;
import model.StartImage;
import model.Version;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ZhihuDailyMockTest {
    private static Gson gson = new Gson();
    private static MockWebServer server = new MockWebServer();
    private static ZhihuDaily zhihuDaily;

    static {
        zhihuDaily = new Retrofit.Builder()
                .baseUrl(server.url("/").toString())
                .addConverterFactory(GsonConverterFactory.create())
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

        StartImage startImage = zhihuDaily.getStartImage(ImageSize.SIZE_1080P).execute().body();
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
        Version version = zhihuDaily.getVersionOfAndroid("2.3.0").execute().body();
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
        Version version = zhihuDaily.getVersionOfIOS("2.3.0").execute().body();
        assertNotNull(version);
        assertEquals(version.getLatest(), response.getLatest());
        assertEquals(version.getStatus(), response.getStatus());
        assertEquals(version.getMsg(), response.getMsg());
    }

    public static void mockServerWith(Object o) {
        server.enqueue(new MockResponse().setBody(gson.toJson(o)));
    }

}
