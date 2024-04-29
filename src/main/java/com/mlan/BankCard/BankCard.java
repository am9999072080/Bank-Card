package com.mlan.BankCard;

import java.util.Objects;

public abstract class BankCard {
    private double balance;


    /**
     * Checking balance
     *
     * @param balance
     */
    public BankCard(double balance) throws RuntimeException {
        if (balance < 0) {
            throw new RuntimeException("Баланс не может быть меньше 0");

        } else {
            this.balance = balance;
        }
    }

    public BankCard() {
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
        if (amount <= 0) {
            throw new RuntimeException("Введенное число должен быть > 0");
        }
        return true;
    }

    /**
     * All Balance
     *
     * @return balance debit, balance credit
     */
    public String checkAllBalance() {
        return balance + "";
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Double.compare(balance, bankCard.balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
