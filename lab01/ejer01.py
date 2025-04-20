def solicitar_numero(nombre_variable):
    while True:
        entrada = input(f"Ingrese el valor de {nombre_variable} (puede ser entero o decimal): ")
        try:
            valor = float(entrada)
            return valor
        except ValueError:
            print(f"Error: '{entrada}' no es un numero valido. Intente nuevamente.")

def calcular_area(base, altura):
    return base * altura

def main():
    print("=== Calculo del área de un rectángulo ===")
    base = solicitar_numero("la base")
    altura = solicitar_numero("la altura")
    
    area = calcular_area(base, altura)
    
    print("\n--- Resultado ---")
    print(f"Base ingresada: {base}")
    print(f"Altura ingresada: {altura}")
    print(f"Area del rectangulo: {area}")

if __name__ == "__main__":
    main()
