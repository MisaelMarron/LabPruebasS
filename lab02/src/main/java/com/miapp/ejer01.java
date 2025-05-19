package com.miapp;

public class ejer01 {
    public static double calcularArea(double base, double altura) {
        if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("El valor debe ser mayor que cero.");
        }
        return base * altura;
    }
}

    /* 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Cálculo del área de un rectángulo ===");
        double base = solicitarNumero("la base", scanner);
        double altura = solicitarNumero("la altura", scanner);
        double area = calcularArea(base, altura);

        System.out.println("\n--- Resultado ---");
        System.out.printf("Base ingresada: %.2f%n", base);
        System.out.printf("Altura ingresada: %.2f%n", altura);
        System.out.printf("Área del rectángulo: %.2f%n", area);
    }
        */

