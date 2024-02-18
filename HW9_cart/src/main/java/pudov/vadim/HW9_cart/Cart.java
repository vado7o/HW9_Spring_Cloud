package pudov.vadim.HW9_cart;

import java.util.HashMap;

public class Cart {
    private Long user_id;
    private HashMap<Product, Long> productList;
    public Cart(Long user_id, HashMap<Product, Long> productList) {
        this.user_id = user_id;
        this.productList = productList;
    }

}
