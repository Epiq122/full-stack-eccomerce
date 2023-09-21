package dev.robgleason.ecommercebackend.repository;

import dev.robgleason.ecommercebackend.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


//@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
@CrossOrigin("http://localhost:4200")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
