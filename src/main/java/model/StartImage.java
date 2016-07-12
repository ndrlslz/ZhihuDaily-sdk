package model;

/**
 * Startup interface image
 */
public class StartImage {
    /**
     * Image text
     */
    private String text;

    /**
     * Image url
     */
    private String img;

    /**
     * Get text
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Set text
     *
     * @param text text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Get image
     *
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * Set image
     *
     * @param img img
     */
    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StartImage that = (StartImage) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return !(img != null ? !img.equals(that.img) : that.img != null);

    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (img != null ? img.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "StartImage{" +
                "text='" + text + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
