package com.mlan.BankCard.controller;


import com.mlan.BankCard.service.impl.CardServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardServiceImpl service;


    @PutMapping("/topUp ")
    @Operation(summary = "Пополнение")
    public double add(@RequestParam double amount) {
        return service.add(amount);
    }


    @PutMapping("/pay")
    @Operation(summary = "Покупка")
    public double pay(@RequestParam double amount) {
        return service.pay(amount);
    }

    @GetMapping("/get")
    @Operation(summary = "Баланс")
    public String check() {
        return service.getBalance();
    }
}