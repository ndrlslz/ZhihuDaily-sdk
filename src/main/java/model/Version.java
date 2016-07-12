package model;

/**
 * ZhihuDaily version
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
        return !(latest != null ? !latest.equals(version.latest) : version.latest != null);

    }

    @Override
    public int hashCode() {
        int result = status;
        result = 31 * result + (msg != null ? msg.hashCode() : 0);
        result = 31 * result + (latest != null ? latest.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Version{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", latest='" + latest + '\'' +
                '}';
    }
}
