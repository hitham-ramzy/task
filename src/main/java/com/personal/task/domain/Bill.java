package com.personal.task.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price_before_discount")
    private Double priceBeforeDiscount;

    @Column(name = "percentage_discount")
    private Double appliedPercentageDiscount;

    @Column(name = "amount_discount")
    private Double amountDiscount;

    @Column(name = "total_price")
    private Double totalPrice;

    @OneToMany(mappedBy = "bill")
    private List<BillItem> items;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User customer;
}
