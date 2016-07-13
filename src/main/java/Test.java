import api.ZhihuDaily;
import model.ImageSize;
import model.StartImage;
import model.Version;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import service.ServiceCall;
import service.ServiceCallback;

import java.io.IOException;

public class Test {
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
    }
}
