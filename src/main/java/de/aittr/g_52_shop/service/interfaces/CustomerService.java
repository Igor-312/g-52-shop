package de.aittr.g_52_shop.service.interfaces;

import de.aittr.g_52_shop.domain.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    // • Сохранить покупателя в базе данных (при сохранении покупатель автоматически считается активным).
    Customer save(Customer customer);

    // • Вернуть всех покупателей из базы данных (активных).
    List<Customer> getAllActiveCustomers();

    // • Вернуть одного покупателя из базы данных по его идентификатору (если он активен).
    Customer getById(Long id);

    // • Изменить одного покупателя в базе данных по его идентификатору.
    void update(Customer customer);

    // • Удалить покупателя из базы данных по его идентификатору.
    void deleteById(Long id);

    // • Удалить покупателя из базы данных по его имени.
    void deleteByName(String name);

    // • Восстановить удалённого покупателя в базе данных по его идентификатору.
    void restoreById(Long id);

    // • Вернуть общее количество покупателей в базе данных (активных).
    long getAllActiveCustomersCount();

    // • Вернуть стоимость корзины покупателя по его идентификатору (если он активен).
    BigDecimal getAllActiveCustomersTotalCost();

    // • Вернуть среднюю стоимость продукта в корзине покупателя по его идентификатору (если он активен)
    BigDecimal getAllActiveCustomersAveragePrice();

    // • Добавить товар в корзину покупателя по их идентификаторам (если оба активны)
    void addProductToCart(Long customerId, Long productId);

    // • Удалить товар из корзины покупателя по их идентификаторам
    void removeProductFromCart(Long customerId, Long productId);

    // • Полностью очистить корзину покупателя по его идентификатору (если он активен)
    void clearCart(Long customerId);

}
