package com.ardaltinay.MealMatic.entity;

import com.ardaltinay.MealMatic.enums.MaterialType;
import com.ardaltinay.MealMatic.enums.MeasurementUnitEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "materials")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material extends AbstractEntity implements Serializable {
    @Column
    private String name;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate expirationDate;

    @Column(name = "remaining_stock", precision = 11, scale = 2)
    private BigDecimal remainingStock;

    @Column(name = "measurement_unit")
    @Enumerated(value = EnumType.STRING)
    private MeasurementUnitEnum measurementUnit;

    @Column(name = "out_of_stock")
    private Boolean outOfStock = false;

    @Column
    @Enumerated(value = EnumType.STRING)
    private MaterialType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
