package com.mlan.BankCard.additionally.exceptions.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    private long id;
    double balance;
    double bonus;
    double accumulation;
}