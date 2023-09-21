package dev.robgleason.ecommercebackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private Integer unitsInStock;

    @CreationTimestamp
    private Date dateCreated;
    @UpdateTimestamp
    private Date lastUpdated;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;


}
