package com.ardaltinay.MealMatic.entity;

import com.ardaltinay.MealMatic.enums.ProductCategoryEnum;
import com.ardaltinay.MealMatic.enums.ProductTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product extends AbstractEntity implements Serializable {
    @Column
    private String name;

    @Column
    private String description;

    @Column(precision = 11, scale = 2)
    private BigDecimal price;

    @Column
    private Short count;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ProductTypeEnum type;

    @Column
    @Enumerated(value = EnumType.STRING)
    private ProductCategoryEnum category;

    @Column(name = "is_best_seller")
    private Boolean isBestSeller;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToMany(mappedBy = "product")
    private List<Material> materials;
}
