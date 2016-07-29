package model;

import java.util.List;

/**
 * Hot news
 * <p>
 * Rest API Example: http://news-at.zhihu.com/api/4/news/hot
 * <p>
 * Json Response Example:
 * <p>
 * {
 * "
 *      recent":[
 *          {
 *              "news_id":8612783,
 *              "url":"http://news-at.zhihu.com/api/2/news/8612783",
 *              "thumbnail":"http://pic2.zhimg.com/c9480247fbaff27d4f2ca4d93e093125.jpg",
 *              "title":"未来五年，最需要的技术人才是什么样的？"
 *          },
 *          {
 *              "news_id":8611138,
 *              "url":"http://news-at.zhihu.com/api/2/news/8611138",
 *              "thumbnail":"http://pic2.zhimg.com/0aab0b56944e929503686ec65ba80ddd.jpg",
 *              "title":"当年特斯拉「吹的牛」已经实现了好多，接下去呢？"
 *          }
 *      ]
 * }
 */
public class HotNews {
    /**
     * List of {@link HotNewsInfo}
     */
    private List<HotNewsInfo> recent;

    /**
     * Get recent
     *
     * @return recent
     */
    public List<HotNewsInfo> getRecent() {
        return recent;
    }

    /**
     * Set recent
     *
     * @param recent recent
     */
    public void setRecent(List<HotNewsInfo> recent) {
        this.recent = recent;
    }

    public static class HotNewsInfo {
        /**
         * News id
         */
        private int news_id;

        /**
         * News content url
         */
        private String url;

        /**
         * News thumbnail
         */
        private String thumbnail;

        /**
         * News title
         */
        private String title;

        /**
         * Get news id
         *
         * @return news_id
         */
        public int getNews_id() {
            return news_id;
        }

        /**
         * Set news id
         *
         * @param news_id news_id
         */
        public void setNews_id(int news_id) {
            this.news_id = news_id;
        }

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            HotNewsInfo that = (HotNewsInfo) o;

            if (news_id != that.news_id) return false;
            if (url != null ? !url.equals(that.url) : that.url != null) return false;
            if (thumbnail != null ? !thumbnail.equals(that.thumbnail) : that.thumbnail != null) return false;
            return !(title != null ? !title.equals(that.title) : that.title != null);

        }

        @Override
        public int hashCode() {
            int result = news_id;
            result = 31 * result + (url != null ? url.hashCode() : 0);
            result = 31 * result + (thumbnail != null ? thumbnail.hashCode() : 0);
            result = 31 * result + (title != null ? title.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "HotNewsInfo{" +
                    "news_id=" + news_id +
                    ", url='" + url + '\'' +
                    ", thumbnail='" + thumbnail + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HotNews hotNews = (HotNews) o;

        return !(recent != null ? !recent.equals(hotNews.recent) : hotNews.recent != null);

    }

    @Override
    public int hashCode() {
        return recent != null ? recent.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "HotNews{" +
                "recent=" + recent +
                '}';
    }
}
