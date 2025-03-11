package de.aittr.g_52_shop.service;

import de.aittr.g_52_shop.domain.entity.Customer;
import de.aittr.g_52_shop.repository.CustomerRepository;
import de.aittr.g_52_shop.service.interfaces.CustomerService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAllActiveCustomers() {
        return List.of();
    }

    @Override
    public Customer getById(Long id) {
        return null;
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(Long id) {

    }

    @Override
    public long getAllActiveCustomersCount() {
        return 0;
    }

    @Override
    public BigDecimal getAllActiveCustomersTotalCost() {
        return null;
    }

    @Override
    public BigDecimal getAllActiveCustomersAveragePrice() {
        return null;
    }

    @Override
    public void addProductToCart(Long customerId, Long productId) {

    }

    @Override
    public void removeProductFromCart(Long customerId, Long productId) {

    }

    @Override
    public void clearCart(Long customerId) {

    }
}
