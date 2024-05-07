package com.mlan.BankCard;

import com.mlan.BankCard.additionally.exceptions.model.Card;

import java.util.Objects;

public abstract class BankCard {
    private final Card card;


    public BankCard(Card card) {
        this.card = card;
    }

    /**
     * Adding bank account
     *
     * @param amount
     */
    public abstract void addBalance(double amount);

    /**
     * Amount on the account
     *
     * @return balance
     */
    public abstract double checkBalance();

    /**
     * @param amount
     * @return true / false
     */
    public boolean pay(double amount) throws RuntimeException {
        if (amount <= 0 || !Double.isFinite(amount)) {
            throw new NumberFormatException("Введенное число должен быть > 0");
        }
        return true;
    }

    /**
     * All Balance
     *
     * @return balance debit, balance credit
     */
    public String checkAllBalance() {
        return card.getBalance() + "";
    }

    public Card getCard() {
        return card;
    }
}