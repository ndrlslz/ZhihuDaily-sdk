package me.ndrlslz.model;

/**
 * Startup interface image
 * <p>
 * Rest API Example: "http://news-at.zhihu.com/api/4/start-image/1080*1776"
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "text":"Jan Schulz",
 *      "img":"https://pic3.zhimg.com/2585173a01d52b49d9714e2c50801d15.jpg"
 * }
 */
public class StartImage {
    /**
     * Image text
     */
    private String text;

    /**
     * Image url
     */
    private String img;

    /**
     * Get text
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Set text
     *
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get image
     *
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * Set image
     *
     * @param img img
     */
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "StartImage{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
