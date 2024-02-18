package pudov.vadim.HW9_reviews;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ReviewService {
    private Long idCount = 1L;

    // создаём список отзывов для имитации наличия отзывов в сервисе
    private final List<Review> reviewList = new ArrayList<>(List.of(
            new Review(idCount++, "Стиральный порошок Х-чистин", "замечательный порошок, отлично" +
                    "вывод пятна, даже самые застарелые! Сумел отстирать даже пятна крови с белой рубашки!"),
            new Review(idCount++, "Зубная паста Зуб-даю", "Пасту попробовали впервые. Действительно" +
                    "превосходно отбеливает! Вся семья в восторге, рекомендую!"),
            new Review(idCount++, "Ноутбук Игрэм", "Не советую! Зависает. Невозможно даже" +
                    "нормально сыграть в Пасьянс Косынку....")
    ));

    // также создадим "Нулевой" отзыв для показа при обращении к несуществующему отзыву
    Review nullReview = new Review(null, "Такого отзыва не существует!", "!");

    // метод для создания отзыва и добавления его в список отзывов. При этом id формируется автоматически
    public Review createReview(String productName, String description) {
        Review review = new Review(idCount++, productName, description);
        reviewList.add(review);
        return review;
    }

    // метод для извлечения отзыва из списке по его id-шнику
    public Review getReview(Long id) {
        return reviewList.stream().filter(review ->
                Objects.equals(review.getProduct_id(), id)).findFirst().orElse(nullReview);
    }

    public List<Review> getReviewList() {
        return reviewList;
    }
}
