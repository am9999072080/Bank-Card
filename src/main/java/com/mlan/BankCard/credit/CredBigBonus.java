package com.mlan.BankCard.credit;

import java.util.Objects;

public class CredBigBonus extends CreditCash {
    private final double potentialCash = 0.05;
    private final double maxAmount = 5000;

    public CredBigBonus() {
    }


    public CredBigBonus(double balance) throws RuntimeException {
        super(balance);
    }

    @Override
    public boolean pay(double amount) {
        super.pay(amount);
        double d;
        if (amount >= 5000) {
            d = amount * potentialCash;
            setBonus(getBonus() + d);
            System.out.print(", Потенциал кешбэк: " + d);
        }
        System.out.print(", Кешбэк всего: " + getBonus());
        return true;
    }

    @Override
    public String checkAllBalance() {
        return super.checkAllBalance() + " CASHBACK " + String.format("%.2f", getBonus());
    }

    public double getPotentialCash() {
        return potentialCash;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CredBigBonus that = (CredBigBonus) o;
        return Double.compare(potentialCash, that.potentialCash) == 0 && Double.compare(maxAmount, that.maxAmount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), potentialCash, maxAmount);
    }
}
