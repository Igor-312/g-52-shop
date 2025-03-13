package de.aittr.g_52_shop.service.interfaces;

import de.aittr.g_52_shop.domain.dto.CustomerDto;
import de.aittr.g_52_shop.domain.dto.ProductDto;
import de.aittr.g_52_shop.domain.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    // • Сохранить покупателя в базе данных (при сохранении покупатель автоматически считается активным).
//    Customer save(Customer customer);
    CustomerDto save(CustomerDto dto);

    // • Вернуть всех покупателей из базы данных (активных).
//    List<Customer> getAllActiveCustomers();
    List<CustomerDto> findAllActiveCustomers();

    // • Вернуть одного покупателя из базы данных по его идентификатору (если он активен).
//    Customer getById(Long id);
    CustomerDto getActiveCustomerById(Long id);

    // • Изменить одного покупателя в базе данных по его идентификатору.
//    void update(Customer customer);
    void update(CustomerDto dto);

    // • Удалить покупателя из базы данных по его идентификатору.
//    void deleteById(Long id);
    void deleteById(CustomerDto dto);

    // • Удалить покупателя из базы данных по его имени.
//    void deleteByName(String name);
    void deleteByName(String name);

    // • Восстановить удалённого покупателя в базе данных по его идентификатору.
//    void restoreById(Long id);
    void restoreById(Long id);

    // • Вернуть общее количество покупателей в базе данных (активных).
//    long getAllActiveCustomersCount();
    long getAllActiveCustomerNumber();

    // • Вернуть стоимость корзины покупателя по его идентификатору (если он активен).
//    BigDecimal getAllActiveCustomersTotalCost();
    BigDecimal getCustomerCartTotalCost(Long customerId);

    // • Вернуть среднюю стоимость продукта в корзине покупателя по его идентификатору (если он активен)
//    BigDecimal getAllActiveCustomersAveragePrice();
    BigDecimal getCustomerProductAveragePrice(Long customerId);

    // • Добавить товар в корзину покупателя по их идентификаторам (если оба активны)
//    void addProductToCart(Long customerId, Long productId);
    void addProductToCustomersCart(Long customerId, Long productId);

    // • Удалить товар из корзины покупателя по их идентификаторам
//    void removeProductFromCart(Long customerId, Long productId);
    void removeProductFromCustomersCart(Long customerId, Long productId);

    // • Полностью очистить корзину покупателя по его идентификатору (если он активен)
//    void clearCart(Long customerId);
    void clearCustomerCart(Long customerId);
}
