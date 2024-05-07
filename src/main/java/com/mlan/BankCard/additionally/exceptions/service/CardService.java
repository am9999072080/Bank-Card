package com.mlan.BankCard.additionally.exceptions.service;

public interface CardService {
    double add(double amount);

    double pay(double amount);

    String getBalance();
}
