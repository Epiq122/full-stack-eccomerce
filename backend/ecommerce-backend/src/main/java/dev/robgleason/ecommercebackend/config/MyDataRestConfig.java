package dev.robgleason.ecommercebackend.config;

import dev.robgleason.ecommercebackend.entity.Product;
import dev.robgleason.ecommercebackend.entity.ProductCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration // Use @Component instead of @Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private final EntityManager entityManager;

    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // Disable HTTP methods for Product: PUT, POST, and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // Disable HTTP methods for ProductCategory: PUT, POST, and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

        // Call an internal helper method to expose IDs
        exposeIds(config);
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // Expose entity IDs

        // Get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // Create an array of the entity type
        List<Class<?>> entityClasses = new ArrayList<>();

        // Get the entity types for the entities
        for (EntityType<?> tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }
        // Expose the entity IDs for the array of entity/domain types
        Class<?>[] domainTypes = entityClasses.toArray(new Class<?>[0]);
        config.exposeIdsFor(domainTypes);
    }
}
