package com.miapp;

public class ejer03 {

    private double saldo;

    public ejer03() {
        this.saldo = 1000.0;  // saldo inicial
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        saldo += monto;
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        } 
        if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        saldo -= monto;
    }
}


