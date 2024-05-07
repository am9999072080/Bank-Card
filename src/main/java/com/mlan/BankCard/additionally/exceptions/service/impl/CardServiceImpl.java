package com.mlan.BankCard.additionally.exceptions.service.impl;


import com.mlan.BankCard.BankCard;
import com.mlan.BankCard.additionally.exceptions.model.Card;

import com.mlan.BankCard.additionally.exceptions.service.CardService;
import com.mlan.BankCard.credit.CreditAccumulation;
import com.mlan.BankCard.credit.CreditCard;

import com.mlan.BankCard.credit.CreditCash;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class CardServiceImpl implements CardService {

    private final BankCard card = new CreditAccumulation(new Card());

    @Override
    public double add(double amount) {

        card.addBalance(amount);
        return card.checkBalance();
    }

    @Override
    public double pay(double amount) {
        card.pay(amount);
        return card.checkBalance();
    }

    @Override
    public String getBalance() {
        return card.checkAllBalance();
    }
}

