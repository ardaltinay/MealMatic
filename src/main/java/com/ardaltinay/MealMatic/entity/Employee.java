package com.ardaltinay.MealMatic.entity;

import com.ardaltinay.MealMatic.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends EntityAbstract implements Serializable {
    @Column
    private String tckn;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String phone;

    @Column(name = "date_of_birth")
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate dateOfBirth;

    @Column
    @Enumerated(value = EnumType.STRING)
    private RoleEnum role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
}
