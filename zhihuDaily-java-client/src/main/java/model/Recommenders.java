package model;

import java.util.List;

/**
 * News recommenders
 * <p>
 * Rest API Example: http://news-at.zhihu.com/api/4/story/7101963/recommenders
 * <p>
 * Json Response Example:
 * <p>
 * {
 *      "items":[
 *      ],
 *      "editors":[
 *          {
 *              "bio":"树上的女爵",
 *              "title":"主编",
 *              "id":79,
 *              "avatar":"http://pic1.zhimg.com/0a6456810_m.jpg",
 *              "name":"刘柯"
 *          }
 *      ],
 *      "item_count":1
 * }
 */
public class Recommenders {
    /**
     * item_count
     */
    private int item_count;

    /**
     * item list
     */
    private List<?> items;

    /**
     * List of {@link Editor}
     */
    private List<Editor> editors;

    /**
     * get item_count
     *
     * @return item_count
     */
    public int getItem_count() {
        return item_count;
    }

    /**
     * Set item_count
     *
     * @param item_count item_count
     */
    public void setItem_count(int item_count) {
        this.item_count = item_count;
    }

    /**
     * Get items
     *
     * @return items
     */
    public List<?> getItems() {
        return items;
    }

    /**
     * Set items
     *
     * @param items items
     */
    public void setItems(List<?> items) {
        this.items = items;
    }

    /**
     * Get editors
     *
     * @return editors
     */
    public List<Editor> getEditors() {
        return editors;
    }

    /**
     * Set editors
     *
     * @param Editors editors
     */
    public void setEditors(List<Editor> Editors) {
        this.editors = Editors;
    }

    @Override
    public String toString() {
        return "Recommenders{" +
                "item_count=" + item_count +
                ", items=" + items +
                ", editors=" + editors +
                '}';
    }
}
