package model;

/**
 * Top Story
 * <p>
 * Used by {@link DailyNews}
 * <p>
 * Json Example:
 * <p>
 * {
 *      "title": "商场和很多人家里，竹制家具越来越多（多图）",
 *      "image": "http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg",
 *      "ga_prefix": "052315",
 *      "type": 0,
 *      "id": 3930883
 * }
 */
public class TopStory {

    /**
     * Top story title
     */
    private String title;

    /**
     * Top story image
     */
    private String image;

    /**
     * Top story ga_prefix, used by Google Analytics
     */
    private String ga_prefix;

    /**
     * Top story type
     */
    private int type;

    /**
     * Top story id
     */
    private int id;

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
     * Get image
     *
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * Set image
     *
     * @param image image
     */
    public void setImage(String image) {
        this.image = image;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TopStory topStory = (TopStory) o;

        if (type != topStory.type) return false;
        if (id != topStory.id) return false;
        if (title != null ? !title.equals(topStory.title) : topStory.title != null) return false;
        if (image != null ? !image.equals(topStory.image) : topStory.image != null) return false;
        return !(ga_prefix != null ? !ga_prefix.equals(topStory.ga_prefix) : topStory.ga_prefix != null);

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (ga_prefix != null ? ga_prefix.hashCode() : 0);
        result = 31 * result + type;
        result = 31 * result + id;
        return result;
    }

    @Override
    public String toString() {
        return "TopStory{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", ga_prefix='" + ga_prefix + '\'' +
                ", type=" + type +
                ", id=" + id +
                '}';
    }
}
