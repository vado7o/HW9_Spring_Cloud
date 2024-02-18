package pudov.vadim.hw9_products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsControllerImpl implements ProductController {
    private final ProductService service;
    @Autowired
    public ProductsControllerImpl(ProductService service) { this.service = service; }
    @GetMapping("/{id}")
    public ResponseEntity<String> getProduct(Long id) {
        return ResponseEntity.ok(service.getProduct(id).toString());
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(service.getProductList());
    }
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestParam String name,
                                                 @RequestParam String description) {
        Product savedProduct = service.createProduct(name, description);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id); }
}
