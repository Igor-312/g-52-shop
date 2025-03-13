package de.aittr.g_52_shop.service;

import de.aittr.g_52_shop.domain.dto.CustomerDto;
import de.aittr.g_52_shop.domain.entity.Cart;
import de.aittr.g_52_shop.domain.entity.Customer;
import de.aittr.g_52_shop.domain.entity.Product;
import de.aittr.g_52_shop.exception_handling.exceptions.CustomerNotFoundException;
import de.aittr.g_52_shop.repository.CustomerRepository;
import de.aittr.g_52_shop.service.interfaces.CustomerService;
import de.aittr.g_52_shop.service.interfaces.ProductService;
import de.aittr.g_52_shop.service.mapping.CustomerMappingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMappingService mappingService;
    private final ProductService productService;

    public CustomerServiceImpl(CustomerRepository repository, CustomerMappingService mappingService, ProductService productService) {
        this.repository = repository;
        this.mappingService = mappingService;
        this.productService = productService;
    }


    @Override
    @Transactional
    public CustomerDto save(CustomerDto dto) {
        Customer entity = mappingService.mapDtoToEntity(dto);

        Cart cart = new Cart();
        cart.setCustomer(entity);
        entity.setCart(cart);

        entity = repository.save(entity);
        return mappingService.mapEntityToDto(entity);
    }

    @Override
    public List<CustomerDto> findAllActiveCustomers() {
        return List.of();
    }

    @Override
    public CustomerDto getActiveCustomerById(Long id) {
        return null;
    }

    private Customer getActiveCustomerEntityById(Long id) {
        return repository.findById(id)
                .filter(Customer::isActive)
                .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @Override
    public void update(CustomerDto dto) {

    }

    @Override
    public void deleteById(CustomerDto dto) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public long getAllActiveCustomerNumber() {
        return 0;
    }

    @Override
    public BigDecimal getCustomerCartTotalCost(Long customerId) {
        return null;
    }

    @Override
    public BigDecimal getCustomerProductAveragePrice(Long customerId) {
        return null;
    }

    @Override
    @Transactional
    public void addProductToCustomersCart(Long customerId, Long productId) {
        Customer customer = getActiveCustomerEntityById(customerId);
        Product product = productService.getActiveProductEntityById(productId);
        customer.getCart().addProduct(product);
    }

    @Override
    public void removeProductFromCustomersCart(Long customerId, Long productId) {

    }

    @Override
    public void clearCustomerCart(Long customerId) {

    }


//    public CustomerServiceImpl(CustomerRepository repository) {
//        this.repository = repository;
//    }

//    @Override
//    public Customer save(Customer customer) {
//        return null;
//    }
//
//    @Override
//    public List<Customer> getAllActiveCustomers() {
//        return List.of();
//    }
//
//    @Override
//    public Customer getById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void update(Customer customer) {
//
//    }
//
//    @Override
//    public void deleteById(Long id) {
//
//    }
//
//    @Override
//    public void deleteByName(String name) {
//
//    }
//
//    @Override
//    public void restoreById(Long id) {
//
//    }
//
//    @Override
//    public long getAllActiveCustomersCount() {
//        return 0;
//    }
//
//    @Override
//    public BigDecimal getAllActiveCustomersTotalCost() {
//        return null;
//    }
//
//    @Override
//    public BigDecimal getAllActiveCustomersAveragePrice() {
//        return null;
//    }
//
//    @Override
//    public void addProductToCart(Long customerId, Long productId) {
//
//    }
//
//    @Override
//    public void removeProductFromCart(Long customerId, Long productId) {
//
//    }
//
//    @Override
//    public void clearCart(Long customerId) {
//
//    }
}
