package lab02.src.main.java.com.miapp;

import java.util.Scanner;

public class ejer03 {
    public static void mostrarMenu() {
        System.out.println("\n=== Menú del Cajero Automático ===");
        System.out.println("1. Consultar Saldo");
        System.out.println("2. Depositar Dinero");
        System.out.println("3. Retirar Dinero");
        System.out.println("4. Salir");
    }

    public static void consultarSaldo(double saldo) {
        System.out.printf("Su saldo actual es: S/. %.2f%n", saldo);
    }

    public static double depositar(double saldo, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        }
        return saldo + monto;
    }

    public static double retirar(double saldo, double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor a cero.");
        } else if (monto > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        return saldo - monto;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0;

        while (true) {
            mostrarMenu();
            System.out.print("Seleccione una opción (1-4): ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    consultarSaldo(saldo);
                    break;
                case "2":
                    try {
                        System.out.print("Ingrese el monto a depositar: ");
                        double montoDeposito = Double.parseDouble(scanner.nextLine());
                        saldo = depositar(saldo, montoDeposito);
                        System.out.printf("Nuevo saldo: S/. %.2f%n", saldo);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "3":
                    try {
                        System.out.print("Ingrese el monto a retirar: ");
                        double montoRetiro = Double.parseDouble(scanner.nextLine());
                        saldo = retirar(saldo, montoRetiro);
                        System.out.printf("Nuevo saldo: S/. %.2f%n", saldo);
                    } catch (NumberFormatException e) {
                        System.out.println("Entrada inválida.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "4":
                    System.out.println("Gracias por usar el cajero. Hasta luego.");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}

