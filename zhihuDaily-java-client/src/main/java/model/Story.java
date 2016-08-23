package model;

import java.util.List;

/**
 * ZhihuDaily Story
 * <p>
 * Used by {@link DailyNews}
 * <p>
 * Json Example:
 * <p>
 * {
 *      "title": "中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）",
 *      "ga_prefix": "052321",
 *      "images": [
 *          "http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"
 *      ],
 *      "type": 0,
 *      "id": 3930445
 * }
 */
public class Story {
    /**
     * Story title
     */
    private String title;

    /**
     * Used by Google Analytics
     */
    private String ga_prefix;

    /**
     * Story type
     */
    private int type;

    /**
     * Story id
     */
    private int id;

    /**
     * Story images list
     */
    private List<String> images;

    /**
     * Get title
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title
     *
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get ga_prefix
     *
     * @return ga_prefix
     */
    public String getGa_prefix() {
        return ga_prefix;
    }

    /**
     * Set ga_prefix
     *
     * @param ga_prefix ga_prefix
     */
    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    /**
     * Get type
     *
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * Set type
     *
     * @param type type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Get id
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set id
     *
     * @param id id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get images
     *
     * @return images
     */
    public List<String> getImages() {
        return images;
    }

    /**
     * Set images
     *
     * @param images images
     */
    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Story{" +
                "title='" + title + '\'' +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", type=" + type +
                ", id=" + id +
                ", images=" + images +
                '}';
    }
}
