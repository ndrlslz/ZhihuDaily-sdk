import api.ZhihuDaily;
import model.ImageSize;
import model.StartImage;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        ZhihuDaily zhihuDaily = ZhihuDailyClient.create();
        StartImage startImage = zhihuDaily.getStartImage(ImageSize.SIZE_1080P).execute();
        System.out.println(startImage.getText() + ", " + startImage.getImg());
    }
}
