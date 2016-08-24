package me.ndrlslz.model;

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
    public String toString() {
        return "Version{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", url='" + url + '\'' +
                ", latest='" + latest + '\'' +
                '}';
    }
}
