package dev.robgleason.ecommercebackend.repository;

import dev.robgleason.ecommercebackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
