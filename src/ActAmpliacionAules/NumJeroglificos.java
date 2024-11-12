package ActAmpliacionAules;

import java.util.Scanner;

public class NumJeroglificos {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escribe el numero que desees (Pulsa 0 para salir del programa):");
        // Valores de los símbolos en notación egipcia y sus representaciones
        int[] valores = {1000000, 100000, 10000, 1000, 100, 10, 1};
        char[] simbolos = {'H', 'R', 'D', 'F', 'C', 'G', 'T'};

        while (true) {
            // Leer el número de la entrada
            int numero = scanner.nextInt();
            if (numero == 0) {
                System.out.println("Saliendo del programa...");
                break; // Terminar si la entrada es 0
            }

            // Convertir el número a notación egipcia
            StringBuilder notacionEgipcia = new StringBuilder();

            for (int i = 0; i < valores.length; i++) {
                while (numero >= valores[i]) {
                    notacionEgipcia.append(simbolos[i]);
                    numero -= valores[i];
                }
            }

            // Imprimir el resultado
            System.out.println(notacionEgipcia.toString());
        }

        scanner.close();
    }
}
