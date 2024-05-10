package com.mlan.BankCard.service;

public interface CardService {
    double add(double amount);

    double pay(double amount);

    String getBalance();
}
