import api.ZhihuDaily;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Comment;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import deserializer.CommentsDeserializer;
import service.ServiceCallAdapterFactory;

import java.lang.reflect.Type;
import java.util.List;

public final class ZhihuDailyClient {
    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";
    private static final Type COMMENTS = new TypeToken<List<Comment>>() {}.getType();
    private static final Gson gson;
    private static ZhihuDaily zhihuDaily;

    static {
        gson = new GsonBuilder()
                .registerTypeAdapter(COMMENTS, new CommentsDeserializer())
                .create();
    }
    private ZhihuDailyClient() {

    }

    public static ZhihuDaily create() {
        if (zhihuDaily == null) {
            synchronized (ZhihuDailyClient.class) {
                if (zhihuDaily == null) {
                    zhihuDaily = createZhihuDaily();
                }
            }
        }
        return zhihuDaily;
    }

    private static ZhihuDaily createZhihuDaily() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(ServiceCallAdapterFactory.create())
                .build()
                .create(ZhihuDaily.class);
    }

}
