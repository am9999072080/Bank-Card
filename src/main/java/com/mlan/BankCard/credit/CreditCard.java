package com.mlan.BankCard.credit;

import com.mlan.BankCard.BankCard;

import java.util.Objects;

public class CreditCard extends BankCard {

    private final double creditLimit = 10_000;
    private double creditBalance = creditLimit;

    public CreditCard() {
    }

    public CreditCard(double balance) throws RuntimeException {
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
            System.out.print("ПОПОЛНЕНИЕ: " + amount + ", DEB: 0.0, CRED: " + amount);
        } else {
            d = creditBalance + amount - creditLimit;
            creditBalance = creditLimit;

            setBalance(getBalance() + d);
            System.out.print("ПОПОЛНЕНИЕ: " + amount + ", DEB: " + d + ", CRED: " + (amount - d));
            System.out.print(", Остаток кредитных средств " + creditLimit);
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
                System.out.print("ПОКУПКА: " + -amount + ", DEB: " + -amount + ", CRED: 0.0");
            } else if (amount <= getBalance() + creditBalance) {
                d = amount - getBalance();
                System.out.print("ПОКУПКА: " + -amount);
                System.out.print(", DEB: " + -getBalance());
                setBalance(0);
                creditBalance = creditBalance - d;
                System.out.print(", CRED: " + -d);
            }
        } else {
            throw new RuntimeException("Недостаточно средств!");
        }
        return super.pay(amount);
    }

    @Override
    public String checkAllBalance() {
        return "\nDEBIT: " + getBalance() + " CREDIT: " + creditBalance;
    }


    public double getCreditLimit() {
        return creditLimit;
    }

    public double getCreditBalance() {
        return creditBalance;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCard that = (CreditCard) o;
        boolean b = Double.compare(creditLimit, that.creditLimit) == 0 && Double.compare(creditBalance, that.creditBalance) == 0;
        return b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), creditLimit, creditBalance);
    }
}