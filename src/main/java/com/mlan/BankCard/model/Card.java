package com.mlan.BankCard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private long id;
    double balance;
    double bonus;
    double accumulation;
}