package ActAmpliacionAules;

import java.util.Scanner;

public class Piramides {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leer el número de casos de prueba
        System.out.println("Introduce los casos de prueba que quieras utilizar: ");
        int numCasos = scanner.nextInt();

        for (int i = 0; i < numCasos; i++) {

            // Leer los años A, B y C
            System.out.printf("Introduce los años: ");
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();

            // Calcular la distancia de A a B y de C a B
            int distanciaA = calcularDistancia(A, B);
            int distanciaC = calcularDistancia(C, B);

            // Determinar cuál está más cerca de B
            if (distanciaA < distanciaC) {
                System.out.println(A);
            } else if (distanciaC < distanciaA) {
                System.out.println(C);
            } else {
                System.out.println("EMPATE");
            }
        }

        scanner.close();
    }

    // Método para calcular la distancia considerando que no existe el año 0
    private static int calcularDistancia(int x, int y) {
        if ((x < 0 && y > 0) || (x > 0 && y < 0)) {
            return Math.abs(x - y) - 1; // Restar 1 si hay cambio de era
        }
        return Math.abs(x - y);
    }
}
