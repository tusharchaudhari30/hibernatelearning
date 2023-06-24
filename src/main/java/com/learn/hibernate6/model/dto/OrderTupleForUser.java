package com.learn.hibernate6.model.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class OrderTupleForUser {
    @Id
    Integer orderId;
    LocalDate orderDate;
    String productName;
    String quantity;
    Double pricePerUnit;
    Double totalPrice;
}
