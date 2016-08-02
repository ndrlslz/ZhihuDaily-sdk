import api.ZhihuDaily;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import deserializer.DateTypeAdapter;
import model.Comment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import deserializer.CommentsDeserializer;
import service.ServiceCallAdapterFactory;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public final class ZhihuDailyClient {
    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";
    private static final Type COMMENTS = new TypeToken<List<Comment>>() {
    }.getType();
    private static final Gson gson;
    private static ZhihuDaily zhihuDaily;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(COMMENTS, new CommentsDeserializer())
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();
    }

    private ZhihuDailyClient() {

    }

    public static ZhihuDaily create() {
        return create(BASE_URL);
    }

    public static ZhihuDaily create(final String baseUrl) {
        if (zhihuDaily == null) {
            synchronized (ZhihuDailyClient.class) {
                if (zhihuDaily == null) {
                    zhihuDaily = createZhihuDaily(baseUrl);
                }
            }
        }
        return zhihuDaily;
    }

    private static ZhihuDaily createZhihuDaily(String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(ServiceCallAdapterFactory.create())
                .build()
                .create(ZhihuDaily.class);
    }

    public static void destroy() {
        zhihuDaily = null;
    }

}
