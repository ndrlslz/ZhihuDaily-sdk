import api.ZhihuDaily;
import model.ImageSize;
import model.StartImage;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ZhihuDaily zhihuDaily = ZhihuDailyClient.create();

        Call<StartImage> call = zhihuDaily.getStartImage(ImageSize.SIZE_1080P);
        Call<StartImage> call1 = call.clone();
        StartImage startImage = call.execute().body();
        System.out.println(startImage);

        call1.enqueue(new Callback<StartImage>() {
            @Override
            public void onResponse(Call<StartImage> call, Response<StartImage> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<StartImage> call, Throwable t) {
            }
        });
    }
}
