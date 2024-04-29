package com.mlan.BankCard.debit;

import java.util.Objects;

public class DebCash extends DebitCard {
    private final double bonusForBuy = 0.01;
    private double bonus;

    public DebCash() {
    }

    public DebCash(double balance) throws RuntimeException {
        super(balance);
    }


    @Override
    public boolean pay(double amount) throws RuntimeException {
        double d;
        if (super.pay(amount)) {
            if (getBalance() >= amount) {
                d = amount * bonusForBuy;
                bonus += d;
                setBalance(getBalance() - amount);
                System.out.print("ПОКУПКА: " + -amount);

                System.out.print(", Кешбэк: " + d);
                System.out.print(", Бонусный баланс: " + bonus);
            } else {
                throw new RuntimeException("Недостаточно средств!");
            }
        }
        return super.pay(amount);
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
        DebCash debCash = (DebCash) o;
        return Double.compare(bonusForBuy, debCash.bonusForBuy) == 0 && Double.compare(bonus, debCash.bonus) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonusForBuy, bonus);
    }
}
