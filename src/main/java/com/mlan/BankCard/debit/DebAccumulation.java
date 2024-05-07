package com.mlan.BankCard.debit;

import com.mlan.BankCard.additionally.exceptions.model.Card;

import java.util.Objects;


public class DebAccumulation extends DebBigBonus {
    private final double percentAccumulation = 0.005;

    public DebAccumulation(Card card) {
        super(card);
    }

    @Override
    public void addBalance(double amount) throws RuntimeException {
        super.addBalance(amount);
        double d = amount * percentAccumulation;
        getCard().setAccumulation(getCard().getAccumulation() + d);
        System.out.print(", Накопление от пополнения: " + d);
        System.out.print(", Баланс накопления: " + getCard().getAccumulation());
    }

    @Override
    public String checkAllBalance() {

        return super.checkAllBalance() + " ACCUMULATION: " + getCard().getAccumulation() + "\n";
    }

    public double getPercentAccumulation() {
        return percentAccumulation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DebAccumulation that = (DebAccumulation) o;
        return Double.compare(percentAccumulation, that.percentAccumulation) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), percentAccumulation);
    }
}
