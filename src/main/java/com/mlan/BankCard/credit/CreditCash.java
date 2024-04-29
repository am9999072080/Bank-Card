package com.mlan.BankCard.credit;

import java.util.Objects;

public class CreditCash extends CreditCard {
    private final double bonusForBuy = 0.01;
    private double bonus;

    public CreditCash(double balance) throws RuntimeException {
        super(balance);
    }

    public CreditCash() {
    }

    @Override
    public boolean pay(double amount) {
        double d;
        if (super.pay(amount)) {
            d = amount * bonusForBuy;
            bonus += d;
            System.out.print(", Кешбэк: " + d);
            System.out.print(", Бонусный баланс: " + bonus);
        } else {
            return super.pay(amount);
        }
        return true;
    }

    public double getBonusForBuy() {
        return bonusForBuy;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CreditCash that = (CreditCash) o;
        return Double.compare(bonusForBuy, that.bonusForBuy) == 0 && Double.compare(bonus, that.bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonusForBuy, bonus);
    }
}
