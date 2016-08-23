package model;

import java.util.List;

/**
 * Themes
 * <p>
 * Rest API Example: http://news-at.zhihu.com/api/4/themes
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "limit":1000,
 *      "subscribed":[
 *      ],
 *      "others":[
 *          {
 *              "color":15007,
 *              "thumbnail":"http://pic3.zhimg.com/0e71e90fd6be47630399d63c58beebfc.jpg",
 *              "description":"了解自己和别人，了解彼此的欲望和局限。",
 *              "id":13,
 *              "name":"日常心理学"
 *          },
 *          {
 *              "color":16046124,
 *              "thumbnail":"http://pic1.zhimg.com/bcf7d594f126e5ceb22691be32b2650a.jpg",
 *              "description":"关注体育，不吵架。",
 *              "id":8,
 *              "name":"体育日报"
 *          }
 *      ]
 * }
 */
public class Themes {

    /**
     * Limit
     */
    private int limit;

    /**
     * Subscribed
     */
    private List<?> subscribed;

    /**
     * List of theme summary
     */
    private List<ThemeSummary> others;

    /**
     * Get limit
     *
     * @return limit
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Set limit
     *
     * @param limit limit
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * Get subscribed
     *
     * @return subscribed
     */
    public List<?> getSubscribed() {
        return subscribed;
    }

    /**
     * Set subscribed
     *
     * @param subscribed subscribed
     */
    public void setSubscribed(List<?> subscribed) {
        this.subscribed = subscribed;
    }

    /**
     * Get others
     *
     * @return others
     */
    public List<ThemeSummary> getOthers() {
        return others;
    }

    /**
     * Set others
     *
     * @param others others
     */
    public void setOthers(List<ThemeSummary> others) {
        this.others = others;
    }

    /**
     * Theme summary
     */
    public static class ThemeSummary {
        /**
         * Color
         */
        private int color;

        /**
         * Thumbnail
         */
        private String thumbnail;

        /**
         * Theme description
         */
        private String description;

        /**
         * Theme id
         */
        private int id;

        /**
         * Theme name
         */
        private String name;

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
         * Get thumbnail
         *
         * @return thumbnail
         */
        public String getThumbnail() {
            return thumbnail;
        }

        /**
         * Set thumbnail
         *
         * @param thumbnail thumbnail
         */
        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

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
            return "ThemeSummary{" +
                    "color=" + color +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", description='" + description + '\'' +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

    }

    @Override
    public String toString() {
        return "Themes{" +
                "limit=" + limit +
                ", subscribed=" + subscribed +
                ", others=" + others +
                '}';
    }
}
