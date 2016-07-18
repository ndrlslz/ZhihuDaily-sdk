package model;

/**
 * ZhihuDaily version
 * <p>
 * Rest API Example: "http://news-at.zhihu.com/api/4/version/android/2.3.0"
 * <p>
 * Json Response Example:
 * <p>
 * {
 * "status": 1,
 * "msg": "【更新内容】",
 * "url":"http://zhstatic.zhihu.com/pkg/store/daily/zhihu-daily-zhihu-2.6.0(744)-release.apk",
 * "latest": "2.2.0"
 * }
 */
public class Version {
    /**
     * Version status
     * 0 means it's latest
     * 1 means it need to update
     */
    private int status;

    /**
     * Updates
     */
    private String msg;

    /**
     * App url address
     */
    private String url;

    /**
     * Latest version
     */
    private String latest;

    /**
     * Get status
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Set status
     *
     * @param status status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * Get msg
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Set msg
     *
     * @param msg msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
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
     * Get latest
     *
     * @return latest
     */
    public String getLatest() {
        return latest;
    }

    /**
     * Set latest
     *
     * @param latest latest
     */
    public void setLatest(String latest) {
        this.latest = latest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Version version = (Version) o;

        if (status != version.status) return false;
        if (msg != null ? !msg.equals(version.msg) : version.msg != null) return false;
        if (url != null ? !url.equals(version.url) : version.url != null) return false;
        return !(latest != null ? !latest.equals(version.latest) : version.latest != null);

    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (latest != null ? latest.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Version{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", latest='" + latest + '\'' +
                '}';
    }
}
