package model;

/**
 * Editor information
 * <p>
 * Used by {@link Theme}
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "url":"http://www.zhihu.com/people/wezeit",
 *      "bio":"微在 Wezeit 主编",
 *      "id":70,
 *      "avatar":"http://pic4.zhimg.com/068311926_m.jpg",
 *      "name":"益康糯米"
 * }
 */
public class Editor {
    /**
     * Url of editor
     */
    private String url;

    /**
     * Bio of editor
     */
    private String bio;

    /**
     * Editor id
     */
    private int id;

    /**
     * Editor avatar
     */
    private String avatar;

    /**
     * Editor name
     */
    private String name;

    /**
     * Get url
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Set url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get bio
     *
     * @return bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Set bio
     *
     * @param bio bio
     */
    public void setBio(String bio) {
        this.bio = bio;
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
     * Get avatar
     *
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Set avatar
     *
     * @param avatar avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * Get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Editor{" +
                "url='" + url + '\'' +
                ", bio='" + bio + '\'' +
                ", id=" + id +
                ", avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
