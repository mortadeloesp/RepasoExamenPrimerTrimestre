package ActAmpliacionAules;

import java.util.Scanner;

public class AlturaPiramide {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Leer el número de bloques de la entrada
            System.out.println("Introduce el numero de bloques: ");
            int bloques = scanner.nextInt();
            if (bloques == 0) {
                break; // Terminar si la entrada es 0
            }

            // Calcular la mínima altura de la pirámide
            int altura = calcularAlturaMinima(bloques);
            System.out.println("La altura minima es: " + altura);
        }

        scanner.close();
    }

    private static int calcularAlturaMinima(int bloques) {
        int altura = 0;
        int sumaBloques = 0;

        // Iterar sumando niveles hasta alcanzar o superar el número de bloques
        while (sumaBloques < bloques) {
            altura++;
            sumaBloques += altura;
        }

        return altura;
    }
}
