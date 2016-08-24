package me.ndrlslz.model;

/**
 * Extra information of news.
 * <p>
 * Rest API Example: http://news-at.zhihu.com/api/4/story-extra/8579705
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "long_comments":66,
 *      "popularity":10476,
 *      "short_comments":546,
 *      "comments":612
 * }
 */
public class ExtraInformation {
    /**
     * Long comments count
     */
    private int long_comments;

    /**
     * Popularity count
     */
    private int popularity;

    /**
     * Short comments count
     */
    private int short_comments;

    /**
     * Comments count
     */
    private int comments;

    /**
     * Get long comments count
     *
     * @return long comments count
     */
    public int getLong_comments() {
        return long_comments;
    }

    /**
     * Set long comments count
     *
     * @param long_comments long comments count
     */
    public void setLong_comments(int long_comments) {
        this.long_comments = long_comments;
    }

    /**
     * Get popularity count
     *
     * @return popularity count
     */
    public int getPopularity() {
        return popularity;
    }

    /**
     * Set popularity count
     *
     * @param popularity popularity count
     */
    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    /**
     * Get short comments count
     *
     * @return short comments count
     */
    public int getShort_comments() {
        return short_comments;
    }

    /**
     * Set short comments count
     *
     * @param short_comments comments count
     */
    public void setShort_comments(int short_comments) {
        this.short_comments = short_comments;
    }

    /**
     * Get comments count
     *
     * @return comments count
     */
    public int getComments() {
        return comments;
    }

    /**
     * Set comments count
     *
     * @param comments comments count
     */
    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "ExtraInformation{" +
                "long_comments=" + long_comments +
                ", popularity=" + popularity +
                ", short_comments=" + short_comments +
                ", comments=" + comments +
                '}';
    }
}
