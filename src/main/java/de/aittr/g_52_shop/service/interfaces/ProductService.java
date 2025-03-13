package de.aittr.g_52_shop.service.interfaces;

import de.aittr.g_52_shop.domain.dto.ProductDto;
import de.aittr.g_52_shop.domain.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

// • Сохранить продукт в базе данных (при сохранении продукт автоматически считается активным).
//    Product save(Product product);
    ProductDto save(ProductDto product);


    // • Вернуть все продукты из базы данных (активные).
//    List<Product> getAllActiveProducts();
    List<ProductDto> getAllActiveProducts();

// • Вернуть один продукт из базы данных по его идентификатору (если он активен).
//    Product getById(Long id);
    ProductDto getById(Long id);

    Product getActiveProductEntityById(Long id);

// • Изменить один продукт в базе данных по его идентификатору.
//    void update(Product product);
    void update(ProductDto product);

// • Удалить продукт из базы данных по его идентификатору.
    void deleteById(Long id);

// • Удалить продукт из базы данных по его наименованию.
    void deleteByTitle(String title);

// • Восстановить удалённый продукт в базе данных по его идентификатору.
    void restoreById(Long id);

// • Вернуть общее количество продуктов в базе данных (активных).
    long getAllActiveProductsCount();

// • Вернуть суммарную стоимость всех продуктов в базе данных (активных).
    BigDecimal getAllActiveProductsTotalCost();

// • Вернуть среднюю стоимость продукта в базе данных (из активных).
    BigDecimal getAllActiveProductsAveragePrice();

//
    void attachImage(String imageUrl, String productTitle);
}
