package com.ardaltinay.MealMatic.entity;

import com.ardaltinay.MealMatic.enums.LocationEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@jakarta.persistence.Table(name = "tables")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Table extends AbstractEntity implements Serializable {
    @Column
    private Short number;

    @Column
    @Enumerated(value = EnumType.STRING)
    private LocationEnum location;

    @Column(precision = 11, scale = 2)
    private BigDecimal bill;

    @Column(name = "is_available")
    private Boolean isAvailable;

    @OneToMany(mappedBy = "table")
    private List<Order> orders;
}
