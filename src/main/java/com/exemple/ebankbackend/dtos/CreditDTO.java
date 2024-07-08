package com.exemple.ebankbackend.dtos;

import lombok.Data;

@Data
public class CreditDTO {
    private String acountId;
    private double amount;
    private String description;
}
