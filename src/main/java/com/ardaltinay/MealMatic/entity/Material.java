package com.ardaltinay.MealMatic.entity;

import com.ardaltinay.MealMatic.enums.MaterialType;
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
import java.time.LocalDate;

@Entity
@Table(name = "material")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material extends EntityAbstract implements Serializable {
    @Column
    private String name;

    @Column
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate expirationDate;

    @Column(name = "remaining_amount")
    private Integer remainingAmount;

    @Column
    @Enumerated(value = EnumType.STRING)
    private MaterialType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
}
