def solicitar_numero(nombre_variable):
    while True:
        entrada = input(f"Ingrese el valor de {nombre_variable} (puede ser entero o decimal): ")
        try:
            valor = float(entrada)
            if valor <= 0:
                print(f"Error: El valor debe ser mayor que cero. Intente nuevamente.")
                continue
            return valor
        except ValueError:
            print(f"Error: '{entrada}' no es un numero valido. Intenta nuevamente.")

def calcular_area(base, altura):
    return base * altura

def main():
    print("=== Calculo del area de un rectangulo ===")
    base = solicitar_numero("la base")
    altura = solicitar_numero("la altura")
    
    area = calcular_area(base, altura)
    
    print("\n--- Resultado ---")
    print(f"Base ingresada: {base}")
    print(f"Altura ingresada: {altura}")
    print(f"Area del rectangulo: {area:.2f}")

if __name__ == "__main__":
    main()
