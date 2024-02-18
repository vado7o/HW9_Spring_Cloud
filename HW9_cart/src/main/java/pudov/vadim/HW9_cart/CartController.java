package pudov.vadim.HW9_cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/carts")
public interface CartController {

    // GET-запрос на извлечение корзины конкретного пользователя с id=user_id
    @GetMapping("/{user_id}")
    ResponseEntity<String> getCart(@PathVariable("user_id") Long user_id);

    // POST-запрос на добавление продукта в корзину пользователя с id=user_id
    @PostMapping("/add/{user_id}")
    ResponseEntity<String> addProduct(@PathVariable("user_id") Long user_id,
                                             @RequestParam String product_name,
                                             @RequestParam String description,
                                             @RequestParam Integer quantity);

    // DELETE-запрос на удаление продукта из корзины пользователя с id=user_id
    @DeleteMapping("/delete/{user_id}")
    ResponseEntity<String> deleteProduct(@PathVariable ("user_id") Long user_id, @RequestParam Long product_id);
}
