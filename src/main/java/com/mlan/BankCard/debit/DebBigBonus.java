package com.mlan.BankCard.debit;

import java.util.Objects;

public class DebBigBonus extends DebCash {
    private final double potentialCash = 0.05;
    private final double bigAmount = 5000;

    public DebBigBonus(double balance) {
        super(balance);

    }

    public DebBigBonus() {
    }


    @Override
    public String checkAllBalance() {
        return "DEBIT BALANCE: " + getBalance() + " CASHBACK " + getBonus();
    }

    @Override
    public boolean pay(double amount) {
        double d;
        if (!super.pay(amount)) {
            if (amount >= bigAmount) {
                d = amount * potentialCash;
                setBonus(getBonus() + amount * potentialCash);
                setBalance(getBalance() - amount);
                //            addBalance(-amount);
                System.out.println("Потенциальный кешбэк: " + d);
                System.out.println("Бонусный баланс: " + getBonus());
            }
        }
        return true;
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
