def es_par(numero):
    return numero % 2 == 0

def main():
    print("=== Identificador de Numeros Pares e Impares ===")
    
    while True:
        try:
            cantidad = int(input("Cuantos numeros desea ingresar?: "))
            if cantidad <= 0:
                print("Por favor, ingrese un numero mayor a cero.")
                continue
            break
        except ValueError:
            print("Entrada invalida. Ingrese un numero entero.")

    numeros = []

    for i in range(cantidad):
        while True:
            try:
                numero = int(input(f"Ingrese el numero {i + 1}: "))
                numeros.append(numero)
                break
            except ValueError:
                print("Entrada invalida. Ingrese un numero entero.")

    print("\n--- Resultado ---")
    for numero in numeros:
        tipo = "par" if es_par(numero) else "impar"
        print(f"El numero {numero} es {tipo}")

if __name__ == "__main__":
    main()
