package com.mlan.BankCard.debit;

import java.util.Objects;

public class DebAccumulation extends DebBigBonus {
    private final double percentAccumulation = 0.005;
    private double accumulation;

    public DebAccumulation() {
    }

    public DebAccumulation(double balance) {
        super(balance);
    }


    @Override
    public void addBalance(double amount) throws RuntimeException {
        super.addBalance(amount);
        double d = amount * percentAccumulation;
        accumulation = accumulation + d;
        System.out.println("Накопление от пополнения: " + d);
        System.out.println("Баланс накопления: " + accumulation);


    }

    @Override
    public String checkAllBalance() {

        return super.checkAllBalance() + " ACCUMULATION: " + accumulation;
    }

    public double getPercentAccumulation() {
        return percentAccumulation;
    }

    public double getAccumulation() {
        return accumulation;
    }

    public void setAccumulation(double accumulation) {
        this.accumulation = accumulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebAccumulation that = (DebAccumulation) o;
        return Double.compare(percentAccumulation, that.percentAccumulation) == 0 && Double.compare(accumulation, that.accumulation) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), percentAccumulation, accumulation);
    }
}
