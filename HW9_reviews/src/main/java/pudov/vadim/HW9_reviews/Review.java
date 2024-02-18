package pudov.vadim.HW9_reviews;

public class Review {
    private Long product_id;
    private String product_name;
    private String description;

    public Review(Long product_id, String product_name, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
    }

    public Review(String product_name, String description) {
        this.product_name = product_name;
        this.description = description;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Найден отзыв: " +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'';
    }
}
