package model;

import java.util.Date;

/**
 * Comment of news.
 * <p>
 * Json Example:
 * {
 *      "author": "EleganceWorld",
 *      "id": 545442,
 *      "content": "上海到济南，无尽的猪排盖饭… ",
 *      "likes": 0,
 *      "time": 1413589303,
 *      "avatar": "http://pic2.zhimg.com/1f76e6a25_im.jpg"
 * }
 */
public class Comment {

    /**
     * Author of comment
     */
    private String author;

    /**
     * Id of author
     */
    private int id;

    /**
     * Content of comment
     */
    private String content;

    /**
     * Count of like
     */
    private int likes;

    /**
     * Comment time
     */
    private Date time;

    /**
     * Avatar address of author
     */
    private String avatar;

    /**
     * Get author
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Set author
     *
     * @param author author
     */
    public void setAuthor(String author) {
        this.author = author;
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
     * Get content
     *
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * Set content
     *
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Get likes
     *
     * @return likes
     */
    public int getLikes() {
        return likes;
    }

    /**
     * Set likes
     *
     * @param likes likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }

    /**
     * Get time
     *
     * @return time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Set time
     *
     * @param time time
     */
    public void setTime(Date time) {
        this.time = time;
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

    @Override
    public String toString() {
        return "Comment{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", time=" + time +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
