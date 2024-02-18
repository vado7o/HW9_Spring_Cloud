package pudov.vadim.HW9_reviews;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewControllerImpl implements ReviewController {
    private final ReviewService service;

    @Autowired
    public ReviewControllerImpl(ReviewService service) { this.service = service; }

    @GetMapping("/{product_id}")
    public ResponseEntity<String> getReview(Long product_id) {
        return ResponseEntity.ok(service.getReview(product_id).toString());
    }
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() { return ResponseEntity.ok(service.getReviewList()); }

    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestParam String productName, @RequestParam String description) {
        Review savedReview = service.createReview(productName, description);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }
}
