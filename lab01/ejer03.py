def mostrar_menu():
    print("\n=== Menu del Cajero Automatico ===")
    print("1. Consultar Saldo")
    print("2. Depositar Dinero")
    print("3. Retirar Dinero")
    print("4. Salir")

def consultar_saldo(saldo):
    print(f"Su saldo actual es: S/. {saldo:.2f}")

def depositar(saldo):
    try:
        monto = float(input("Ingrese el monto a depositar: "))
        if monto <= 0:
            print("El monto debe ser mayor a cero.")
        else:
            saldo += monto
            print(f"Se ha depositado S/. {monto:.2f}. Nuevo saldo: S/. {saldo:.2f}")
    except ValueError:
        print("Entrada invalida. Ingrese un numero valido.")
    return saldo

def retirar(saldo):
    try:
        monto = float(input("Ingrese el monto a retirar: "))
        if monto <= 0:
            print("El monto debe ser mayor a cero.")
        elif monto > saldo:
            print("Fondos insuficientes. No se puede completar la operacion.")
        else:
            saldo -= monto
            print(f"Se ha retirado S/. {monto:.2f}. Nuevo saldo: S/. {saldo:.2f}")
    except ValueError:
        print("Entrada invalida. Ingrese un numero valido.")
    return saldo

def main():
    saldo = 1000.0
    while True:
        mostrar_menu()
        opcion = input("Seleccione una opcion (1-4): ")

        if opcion == "1":
            consultar_saldo(saldo)
        elif opcion == "2":
            saldo = depositar(saldo)
        elif opcion == "3":
            saldo = retirar(saldo)
        elif opcion == "4":
            print("Gracias por usar el cajero. Hasta luego.")
            break
        else:
            print("Opcion invalida. Intente nuevamente.")

if __name__ == "__main__":
    main()
