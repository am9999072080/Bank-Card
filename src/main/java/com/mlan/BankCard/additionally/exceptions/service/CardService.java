package com.mlan.BankCard.additionally.exceptions.service;


import com.mlan.BankCard.BankCard;
import com.mlan.BankCard.additionally.exceptions.model.Card;

import com.mlan.BankCard.debit.DebAccumulation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class CardService {

    private final BankCard card = new DebAccumulation(new Card());

    public double add(double amount) {

        card.addBalance(amount);
        return card.checkBalance();
    }

    public double pay(double amount) {
        card.pay(amount);
        return card.checkBalance();
    }

    public String getBalance() {
        return card.checkAllBalance();
    }
}


