package com.mlan.BankCard.debit;

import com.mlan.BankCard.BankCard;

public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    public DebitCard() {
    }

    @Override
    public void addBalance(double amount) throws RuntimeException {
        if (amount <= 0) {
            throw new RuntimeException("Введенное число должен быть > 0");
        }
        setBalance(getBalance() + amount);
        System.out.println("Пополнения, DEBIT: " + amount);
    }

    @Override
    public double checkBalance() {
        System.out.print("Доступно, DEBIT: ");
        return getBalance();
    }
}
