package lab02.src.main.java.com.miapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejer02 {
    public static boolean esPar(int numero) {
        System.out.println("////PRUEBA////");
        
        if (numero % 2 == 0)
            System.out.println(numero +" es par");
    
        else 
            System.out.println(numero +" es impar");

        return numero % 2 == 0;
    }

    /*
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Identificador de Números Pares e Impares ===");

        int cantidad;
        while (true) {
            try {
                System.out.print("¿Cuántos números desea ingresar?: ");
                cantidad = Integer.parseInt(scanner.nextLine());
                if (cantidad <= 0) {
                    System.out.println("Por favor, ingrese un número mayor a cero.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }

        List<Integer> numeros = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            while (true) {
                try {
                    System.out.print("Ingrese el número " + (i + 1) + ": ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    numeros.add(numero);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Ingrese un número entero.");
                }
            }
        }

        System.out.println("\n--- Resultado ---");
        for (int numero : numeros) {
            String tipo = esPar(numero) ? "par" : "impar";
            System.out.println("El número " + numero + " es " + tipo);
        }
    } */
}
