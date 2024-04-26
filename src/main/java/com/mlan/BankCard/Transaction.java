package com.mlan.BankCard;

import com.mlan.BankCard.credit.CreditAccumulation;
import com.mlan.BankCard.debit.DebAccumulation;

public class Transaction {
    public static void main(String[] args) {
        BankCard debAccumulation = new DebAccumulation();
        BankCard creditAccumulation = new CreditAccumulation();

        System.out.println("---CREDIT-DEBIT---");
        System.out.println(creditAccumulation.checkAllBalance());
        creditAccumulation.addBalance(5000);
        System.out.println(creditAccumulation.checkAllBalance());
        creditAccumulation.pay(5000);
        System.out.println(creditAccumulation.checkAllBalance());
        creditAccumulation.pay(3000);
        System.out.println(creditAccumulation.checkAllBalance());
        creditAccumulation.addBalance(2000);
        System.out.println(creditAccumulation.checkAllBalance());
        creditAccumulation.addBalance(2000);
        System.out.println(creditAccumulation.checkAllBalance());


        System.out.println("\n---DEBIT---\n");

        System.out.println(debAccumulation.checkAllBalance());
        debAccumulation.addBalance(15000);
        System.out.println(debAccumulation.checkAllBalance());
        debAccumulation.pay(5000);
        System.out.println(debAccumulation.checkAllBalance());
        debAccumulation.pay(3000);
        System.out.println(debAccumulation.checkAllBalance());
        debAccumulation.addBalance(2000);
        System.out.println(debAccumulation.checkAllBalance());
        debAccumulation.addBalance(2000);
        System.out.println(debAccumulation.checkAllBalance());
    }
}
