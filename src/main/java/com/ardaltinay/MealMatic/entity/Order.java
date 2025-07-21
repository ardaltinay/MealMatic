package com.ardaltinay.MealMatic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends AbstractEntity implements Serializable {
    @Column(name = "order_number")
    private String orderNumber;

    @Column(precision = 11, scale = 2)
    private BigDecimal price;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToOne(mappedBy = "order")
    private Employee employee;

    @OneToMany(mappedBy = "order")
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private com.ardaltinay.MealMatic.entity.Table table;

}
