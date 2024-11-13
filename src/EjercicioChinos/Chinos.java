package EjercicioChinos;

import java.util.Random;
import java.util.Scanner;

public class Chinos {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int victoriasJugador = 0;
        int victoriasMaquina = 0;
        boolean empiezaJugador = true;

        System.out.println("Bienvenido al juego de los chinos");


            while (victoriasJugador < 5 && victoriasMaquina < 5) {
                int monedasJugador;
                int monedasMaquina;
                int apuestaJugador;
                int apuestaMaquina;

                //1. Seleccion de monedas
                do {
                    System.out.println("Elige con cuantas monedas deseas jugar (0-3): ");
                    monedasJugador = scanner.nextInt();
                } while (monedasJugador < 0 || monedasJugador > 3);


                monedasMaquina = random.nextInt(4); //El ordenador elegirá entre (0-3)
                System.out.println("La máquina ha escogido: " + monedasMaquina);



                //2. Apuesta para adivinar la suma total
                if (empiezaJugador) {
                    do {
                        System.out.println("Adivina la suma total (0-6): ");
                        apuestaJugador = scanner.nextInt();
                    } while (apuestaJugador < 0 || apuestaJugador > 6);

                    //Apuesta de la máquina
                    do {
                        apuestaMaquina = random.nextInt(7); //Entre 0-6
                    } while (apuestaMaquina == apuestaJugador);
                    System.out.println("El ordenador apuesta: " + apuestaMaquina);
                } else {
                    //Apuesta primero la máquina
                    apuestaMaquina = random.nextInt(7); //Entre 0-6
                    System.out.println("El ordenador apuesta: " + apuestaMaquina);

                    do {
                        System.out.println("Adivina la suma total (0-6): ");
                        apuestaJugador = scanner.nextInt();
                    } while (apuestaJugador < 0 || apuestaJugador > 6 || apuestaJugador == apuestaMaquina);


                }

                //Resolucion del juego
                int sumaTotal = monedasJugador + monedasMaquina;
                System.out.println("La suma total de monedas es: " + sumaTotal);

                if (apuestaJugador == sumaTotal) {
                    System.out.println("Has ganado esta ronda Jugador.");
                    victoriasJugador++;
                } else if (apuestaMaquina == sumaTotal) {
                    System.out.println("Has ganado esta ronda Máquina.");
                    victoriasMaquina++;
                } else {
                    System.out.println("Nadie ha ganado, situación de empate.");
                }
                System.out.println("Marcador: Jugador " + victoriasJugador + " - " + victoriasMaquina + " Máquina");

                // Cambiar el que empieza en la siguiente ronda
                empiezaJugador = !empiezaJugador;
            }

            // 4. Comprobar ganador final
            if (victoriasJugador == 5) {
                System.out.println("¡Felicidades, has ganado el juego!");
            } else {
                System.out.println("El ordenador ha ganado el juego. ¡Suerte la próxima vez!");
            }
            scanner.close();
        }
}


