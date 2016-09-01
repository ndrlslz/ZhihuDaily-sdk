package com.github.ndrlslz.model;

import java.util.List;

/**
 * Daily news
 * <p>
 * Rest API Example: "http://news-at.zhihu.com/api/4/news/latest"
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "date": "20140523",
 *      "stories": [
 *          {
 *              "title": "中国古代家具发展到今天有两个高峰，一个两宋一个明末（多图）",
 *              "ga_prefix": "052321",
 *              "images": [
 *                  "http://p1.zhimg.com/45/b9/45b9f057fc1957ed2c946814342c0f02.jpg"
 *              ],
 *              "type": 0,
 *              "id": 3930445
 *          },
 *      ],
 *      "top_stories": [
 *          {
 *              "title": "商场和很多人家里，竹制家具越来越多（多图）",
 *              "image": "http://p2.zhimg.com/9a/15/9a1570bb9e5fa53ae9fb9269a56ee019.jpg",
 *              "ga_prefix": "052315",
 *              "type": 0,
 *              "id": 3930883
 *          },
 *      ]
 * }
 */
public class DailyNews {

    /**
     * Date
     */
    private String date;

    /**
     * List of {@link Story}
     */
    private List<Story> stories;

    /**
     * List of {@link TopStory}
     */
    private List<TopStory> top_stories;

    /**
     * Get date
     *
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set date
     *
     * @param date date
     */
    public void setDate(String date) {
        this.date = date;
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
     * Get top_stories
     *
     * @return top_stories
     */
    public List<TopStory> getTop_stories() {
        return top_stories;
    }

    /**
     * Set top_stories
     *
     * @param top_stories top_stories
     */
    public void setTop_stories(List<TopStory> top_stories) {
        this.top_stories = top_stories;
    }

    @Override
    public String toString() {
        return "DailyNews{" +
                "date='" + date + '\'' +
                ", stories=" + stories +
                ", top_stories=" + top_stories +
                '}';
    }
}
