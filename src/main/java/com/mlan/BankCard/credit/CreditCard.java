package com.mlan.BankCard.credit;

import com.mlan.BankCard.BankCard;

import java.util.Objects;

public class CreditCard extends BankCard {

    private final double creditLimit = 10_000;
    private double creditBalance = creditLimit;

    public CreditCard() {
    }

    public CreditCard(double balance) {
        super(balance);

    }

    @Override
    public void addBalance(double amount) throws RuntimeException {
        if (amount <= 0) {
            throw new RuntimeException("Введенное число должен быть > 0");
        }
        double d;
        if (creditBalance + amount <= creditLimit) {
            creditBalance = creditBalance + amount;
            System.out.println("Пополнения, CREDIT: " + amount);
        } else {
            d = creditBalance + amount - creditLimit;
            creditBalance = creditLimit;
            System.out.println("Кредитный лимит составляет " + creditLimit);
            setBalance(getBalance() + d);
            System.out.println("Пополнения, DEBIT: " + d);
        }
    }

    @Override
    public double checkBalance() {
        System.out.print("Доступно, D/C: ");
        return getBalance() + creditBalance;
    }

    @Override
    public boolean pay(double amount) {
        double d;
        if (!(getBalance() + creditBalance < amount)) {
            if (getBalance() >= amount) {
                setBalance(getBalance() - amount);
                System.out.println("Оплата, DEBIT: " + -amount);
            } else if (amount <= getBalance() + creditBalance) {
                d = amount - getBalance();
                System.out.println("Оплата, DEBIT: " + -getBalance());
                setBalance(0);
                creditBalance = creditBalance - d;
                System.out.println("Оплата, CREDIT: " + -d);
            }
        } else {
            throw new RuntimeException("Недостаточно средств!");
        }
        return super.pay(amount);
    }

    @Override
    public String checkAllBalance() {
        return "DEBIT: " + getBalance() + " CREDIT: " + creditBalance;
    }


    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCard that = (CreditCard) o;
        return Double.compare(creditLimit, that.creditLimit) == 0 && Double.compare(creditBalance, that.creditBalance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditLimit, creditBalance);
    }
}
