def cargar_palabras():
    palabrasConFrecuencia = {}

    with open('palabras.txt') as listaPalabras:
        for palabra in listaPalabras:
            if palabra in palabrasConFrecuencia:
                palabrasConFrecuencia[palabra] += 1  # Suma 1 al valor de la clave que esté repetida
            else:
                palabrasConFrecuencia[palabra] = 1  # Guarda la clave (palabra) con un valor (frecuencia) de 1

    return palabrasConFrecuencia


def mostrar_palabras(palabras):
    if not palabras:
        print("No hay palabras clave cargadas.")
        return

    palabras_por_pagina = 20

    for i, (palabra, frecuencia) in enumerate(palabras.items(), 1):
        print(f"{i}. {palabra} - Frecuencia: {frecuencia}")

        if i % palabras_por_pagina == 0:
            input("Presiona Enter para ver las siguientes palabras clave...")


palabras = {}
while True:
    print("\n[1] – Importar palabras clave")
    print("[2] – Mostrar palabras clave")
    print("[0] – Salir")

    opcion = input("Seleccione una opción:")

    if opcion == '1':
        palabras = cargar_palabras()
        print("Palabras importadas con éxito.")

    elif opcion == '2':
        mostrar_palabras(palabras)

    elif opcion == '0':
        print("Saliendo del programa. ¡Hasta luego!")
        break
    else:
        print("Opción no válida. Inténtalo de nuevo.")
