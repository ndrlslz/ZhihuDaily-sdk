package model;

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
     * //TODO switch to Date type.
     */
    private int time;

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
    public int getTime() {
        return time;
    }

    /**
     * Set time
     *
     * @param time time
     */
    public void setTime(int time) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (likes != comment.likes) return false;
        if (time != comment.time) return false;
        if (author != null ? !author.equals(comment.author) : comment.author != null) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        return !(avatar != null ? !avatar.equals(comment.avatar) : comment.avatar != null);

    }

    @Override
    public int hashCode() {
        int result = author != null ? author.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + likes;
        result = 31 * result + time;
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        return result;
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
