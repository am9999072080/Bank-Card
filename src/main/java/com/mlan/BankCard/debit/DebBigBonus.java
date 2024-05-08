package com.mlan.BankCard.debit;

import java.util.Objects;

public class DebBigBonus extends DebCash {
    private final double potentialCash = 0.05;
    private final double bigAmount = 5000;

    public DebBigBonus() {
    }

    public DebBigBonus(double balance) throws RuntimeException {
        super(balance);
    }


    @Override
    public boolean pay(double amount) {
        super.pay(amount);
        double d;
        if (amount >= 5000) {
            d = amount * potentialCash;
            System.out.print(", Потенциал кешбэк: " + d);
            setBonus(getBonus() + d);

        }
        System.out.print(", Кешбэк всего: " + getBonus());
        return true;
    }

    @Override
    public String checkAllBalance() {
        return "\nDEBIT BALANCE: " + String.format("%.2f", getBalance()) + " CASHBACK " + String.format("%.2f", getBonus());
    }

    public double getPotentialCash() {
        return potentialCash;
    }

    public double getBigAmount() {
        return bigAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebBigBonus that = (DebBigBonus) o;
        return Double.compare(potentialCash, that.potentialCash) == 0 && Double.compare(bigAmount, that.bigAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), potentialCash, bigAmount);
    }
}
