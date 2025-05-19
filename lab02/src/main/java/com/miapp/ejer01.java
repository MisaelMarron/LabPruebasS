package lab02.src.main.java.com.miapp;

import java.util.Scanner;

public class ejer01 {
    /* 
    public static double solicitarNumero(String nombreVariable, Scanner scanner) {
        double valor;
        while (true) {
            try {
                System.out.print("Ingrese el valor de " + nombreVariable + " (puede ser entero o decimal): ");
                valor = Double.parseDouble(scanner.nextLine());
                if (valor <= 0) {
                    System.out.println("Error: El valor debe ser mayor que cero. Intente nuevamente.");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: No es un número válido. Intente nuevamente.");
            }
        }
    }
        */
    public static double calcularArea(double base, double altura) {
        System.out.println("/////PRUEBA///// base: " + base + " altura : "+ altura + " area calculada: " + (base * altura));
        return base * altura;
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
}
