package com.exemple.ebankbackend.dtos;

import lombok.Data;

@Data
public class DebitDTO {
    private String acountId;
    private double amount;
    private String description;
}
