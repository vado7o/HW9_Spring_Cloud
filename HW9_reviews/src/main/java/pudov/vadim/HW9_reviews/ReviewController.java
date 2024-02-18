package pudov.vadim.HW9_reviews;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/reviews")
public interface ReviewController {

    // GET-запрос на показ отзыва на продукцию с переданным id-шником
    @GetMapping("/{product_id}")
    ResponseEntity<String> getReview(@PathVariable("product_id") Long id);

    // GET-запрос на показ всех имеющихся в базе отзывов
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews();

    // POST-запрс на создание и добавление в базу отзыва на продукт
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestParam String productName, @RequestParam String description);
}
