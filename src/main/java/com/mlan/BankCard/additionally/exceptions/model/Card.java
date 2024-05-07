package com.mlan.BankCard.additionally.exceptions.model;

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