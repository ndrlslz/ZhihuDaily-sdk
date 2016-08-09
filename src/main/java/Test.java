import api.ZhihuDaily;
import exception.HttpException;
import model.HotNews;
import model.ImageSize;
import model.StartImage;
import service.ServiceCallback;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ZhihuDaily zhihuDaily = ZhihuDailyClient.create();

        zhihuDaily.getStartImage(ImageSize.SIZE_1080P).enqueue(new ServiceCallback<StartImage>() {
            @Override
            public void onResponse(StartImage object) {
                System.out.println(object);
            }

            @Override
            public void onFailure(HttpException httpException) {
                System.out.println(httpException.getMessage());
            }
        });

        StartImage startImage = zhihuDaily.getStartImage(ImageSize.SIZE_1080P).execute();
        System.out.println(startImage);

        zhihuDaily.getHotNews().enqueue(new ServiceCallback<HotNews>() {
            @Override
            public void onResponse(HotNews object) {
                System.out.println(object);
            }

            @Override
            public void onFailure(HttpException exception) {

            }
        });
    }
}
