package pudov.vadim.HW9_cart;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {

    // Создаём для примера одну корзину с перечнем продуктов в ней
    private final HashMap<Product, Integer> productList = new HashMap<>(){{
        put(new Product(773L, "Влажные салфетки Детские", "салфетки для детей от 3 лет"), 2);
        put(new Product(9L, "Книга Войти в Айти", "БестСеллер Гика Брэйнс"), 1);
        put(new Product(1034L, "Ёршик для унитаза Саломон", "Средство гигиены для всей семьи"), 1);
        put(new Product(4431L, "Пуговица швейная Алсу", "Пуговица для одежды Атласного цвета"), 8);
        }};

    // создаём для примера перечень корзин и включаем в него ранее созданную корзину для пользователя с id=12
    private final HashMap<Long, HashMap<Product, Integer>> cartList = new HashMap<>(){{put(12L, productList);}};


    // метод просмотра состава корзины пользователя с id=user_id
    public String getCart(Long user_id) {
        StringBuilder sb = new StringBuilder("В вашей корзине:\n");
        if (!cartList.containsKey(user_id)) return "Корзина пуста!";
        else {
            cartList.get(user_id).forEach((product, integer) ->
                    sb.append("ID: ")
                    .append(product.getId())
                    .append(". ")
                    .append(product.getName())
                    .append(". Описание продукта: ")
                    .append(product.getDescription())
                    .append(". Количество: ")
                    .append(integer)
                    .append(".\n"));
            return sb.toString();
        }
    }

    // метод для добавления продукта в корзину пользователя с id=user_id
    public String addProduct(Long user_id, Long productId, String productName, String description, Integer quantity) {
        if (!cartList.containsKey(user_id)) cartList.keySet().add(user_id);
        cartList.get(user_id).put(new Product(productId, productName, description), quantity);
        return "Успешно добавлено в корзину!";
    }

    // метод удаления продукта из корзины пользователя c id-шником
    public String deleteProduct(Long user_id, Long product_id) {
        if (!cartList.containsKey(user_id)) return "Такого пользователя не существует!";
        else {
            cartList.get(user_id).forEach((product, integer) ->
            {if(Objects.equals(product.getId(), product_id)) cartList.get(user_id).remove(product, integer);});
        }
        return "Успешно удалено из корзины";
    }

    // метод для извлечения всех имеющихся корзин
    public HashMap<Long, HashMap<Product, Integer>> getCartList() {
        return cartList;
    }
}
