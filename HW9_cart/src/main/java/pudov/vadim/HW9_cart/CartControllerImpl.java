package pudov.vadim.HW9_cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Random;

@RestController
public class CartControllerImpl implements CartController {
    private final CartService service;

    @Autowired
    public CartControllerImpl(CartService service) { this.service = service; }

    @GetMapping("/{user_id}")
    public ResponseEntity<String> getCart(@PathVariable("user_id") Long user_id) {
        return ResponseEntity.ok(service.getCart(user_id));
    }
    @PostMapping("/add/{user_id}")
    public ResponseEntity<String> addProduct(@PathVariable("user_id") Long user_id,
                                             @RequestParam String product_name,
                                             @RequestParam String description,
                                             @RequestParam Integer quantity) {
        if (!service.getCartList().containsKey(user_id)) return ResponseEntity.ok("Корзина не найдена!");
        else {
            service.getCartList().get(user_id).put(new Product(new Random().nextLong(100L, 1000L),
                    product_name, description), quantity);
            return ResponseEntity.ok(service.getCart(user_id));
        }
    }

    @DeleteMapping("/delete/{user_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable ("user_id") Long user_id, @RequestParam Long product_id) {
        if (!service.getCartList().containsKey(user_id)) return ResponseEntity.ok("Корзина не найдена!");
        else {
            service.getCartList().get(user_id).forEach((product, integer) -> {
                if(Objects.equals(product.getId(), product_id)) service.getCartList().get(user_id).remove(product, integer);});
            return ResponseEntity.ok(service.getCart(user_id));
        }
    }
}
