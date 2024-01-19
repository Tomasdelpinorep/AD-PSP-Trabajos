def cargar_palabras():
    palabras = []
    with open('palabras.txt') as listaPalabras:
        palabras = listaPalabras.read().splitlines()

    return palabras


def mostrar_palabras(palabras):
    if not palabras:
        print('No se han cargado palabras.')
        return

    pagina = 1
    palabras_por_pagina = 20

    while True:
        inicio = (pagina - 1) * palabras_por_pagina
        fin = pagina * palabras_por_pagina
        palabras_pagina_actual = palabras[inicio:fin]

        for palabra in palabras_pagina_actual:
            print(palabra)

        if fin >= len(palabras):
            break

        input("Presiona Enter para ver las siguientes palabras clave...")
        pagina += 1


palabras = []
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
