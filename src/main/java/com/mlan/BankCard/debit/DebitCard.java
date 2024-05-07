package com.mlan.BankCard.debit;

import com.mlan.BankCard.BankCard;

import com.mlan.BankCard.additionally.exceptions.model.Card;

public class DebitCard extends BankCard {
    public DebitCard(Card card) {
        super(card);
    }

    @Override
    public void addBalance(double amount) throws RuntimeException {
        if (amount <= 0) {
            throw new RuntimeException("Введенное число должен быть > 0");
        }
        getCard().setBalance(getCard().getBalance() + amount);

        System.out.print("ПОПОЛНЕНИЕ: " + amount);
    }

    @Override
    public double checkBalance() {
        return getCard().getBalance();
    }
}