package com.github.ndrlslz.model;

import java.util.List;

/**
 * Theme
 * <p>
 * Rest API Example: http://news-at.zhihu.com/api/4/theme/11
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "stories":[
 *          {
 *              "images":[
 *                  "http://pic3.zhimg.com/55b7c5c7f8d2042698e4f606daab3792_t.jpg"
 *              ],
 *              "type":2,
 *              "id":7258022,
 *              "title":"再次陪跑诺奖的村上春树接受了我们的采访"
 *          }
 *      ],
 *      "description":"为你发现最有趣的新鲜事，建议在 WiFi 下查看",
 *      "background":"http://pic1.zhimg.com/a5128188ed788005ad50840a42079c41.jpg",
 *      "color":8307764,
 *      "name":"不许无聊",
 *      "image":"http://pic3.zhimg.com/da1fcaf6a02d1223d130d5b106e828b9.jpg",
 *      "editors":[
 *          {
 *              "url":"http://www.zhihu.com/people/kuangzhou",
 *              "bio":"明月般俊朗",
 *              "id":71,
 *              "avatar":"http://pic4.zhimg.com/43d10de2b46c918a9ffe5d0472947b67_m.jpg",
 *              "name":"顾惜朝"
 *          }
 *      ],
 *      "image_source":""
 * }
 */
public class Theme {
    /**
     * Theme description
     */
    private String description;

    /**
     * Background
     */
    private String background;

    /**
     * Color
     */
    private int color;

    /**
     * Name
     */
    private String name;

    /**
     * Image address
     */
    private String image;

    /**
     * Image source
     */
    private String image_source;

    /**
     * List of {@link Story}
     */
    private List<Story> stories;

    /**
     * List of {@link Editor}
     */
    private List<Editor> editors;

    /**
     * Get description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     *
     * @param description description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get background
     *
     * @return background
     */
    public String getBackground() {
        return background;
    }

    /**
     * Set background
     *
     * @param background background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Get color
     *
     * @return color
     */
    public int getColor() {
        return color;
    }

    /**
     * Set color
     *
     * @param color color
     */
    public void setColor(int color) {
        this.color = color;
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
     * Get image_source
     *
     * @return image_source
     */
    public String getImage_source() {
        return image_source;
    }

    /**
     * Set image_source
     *
     * @param image_source image_source
     */
    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    /**
     * Get stories
     *
     * @return stories
     */
    public List<Story> getStories() {
        return stories;
    }

    /**
     * Set stories
     *
     * @param stories stories
     */
    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    /**
     * Get editors
     *
     * @return editors
     */
    public List<Editor> getEditors() {
        return editors;
    }

    /**
     * Set editors
     *
     * @param editors editors
     */
    public void setEditors(List<Editor> editors) {
        this.editors = editors;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "description='" + description + '\'' +
                ", background='" + background + '\'' +
                ", color=" + color +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", image_source='" + image_source + '\'' +
                ", stories=" + stories +
                ", editors=" + editors +
                '}';
    }
}
