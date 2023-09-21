package dev.robgleason.ecommercebackend.repository;

import dev.robgleason.ecommercebackend.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;


//@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
