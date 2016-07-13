import api.ZhihuDaily;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.ServiceCallAdapterFactory;

public final class ZhihuDailyClient {
    private static final String BASE_URL = "http://news-at.zhihu.com/api/4/";
    private static ZhihuDaily zhihuDaily;

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
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(ServiceCallAdapterFactory.create())
                .build()
                .create(ZhihuDaily.class);
    }

}
