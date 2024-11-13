package EjercicioCerdos;

import java.util.Scanner;

public class Cerdos {
    static final int PUNTOS_META = 50;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreJugador;

        // Validación del nombre del jugador
        while (true) {
            System.out.print("Introduce tu nombre de jugador siguiendo las instrucciones: ");
            nombreJugador = scanner.nextLine();
            if (esNombreValido(nombreJugador)) {
                break;
            } else {
                System.out.println("Nombre no válido. Inténtalo de nuevo.");
            }
        }

        boolean jugarDeNuevo;
        do {
            jugarDeNuevo = jugarPartida(nombreJugador, scanner);
        } while (jugarDeNuevo);

        System.out.println("¡Gracias por jugar!");
    }

    // Valida si el nombre del jugador cumple con las reglas
    public static boolean esNombreValido(String nombre) {
        if (nombre.length() > 30 || !nombre.matches("[a-zA-Z][a-zA-Z_]*[a-zA-Z]")) {
            return false;
        }
        return !nombre.contains("__");
    }

    // Método para realizar una partida
    public static boolean jugarPartida(String nombreJugador, Scanner scanner) {
        int puntajeJugador = 0;
        int puntajeMaquina = 0;
        boolean turnoJugador = true;

        while (puntajeJugador < PUNTOS_META && puntajeMaquina < PUNTOS_META) {
            if (turnoJugador) {
                System.out.println("Turno de " + nombreJugador + ":");
                puntajeJugador += turnoJugador(scanner, nombreJugador);
                turnoJugador = false;
            } else {
                System.out.println("Turno de la máquina:");
                puntajeMaquina += turnoMaquina();
                turnoJugador = true;
            }

            System.out.println("La puntuación total es: " + nombreJugador + " " + puntajeJugador + " – Máquina " + puntajeMaquina);
        }

        if (puntajeJugador >= PUNTOS_META && puntajeMaquina < PUNTOS_META) {
            System.out.println("¡HA GANADO " + nombreJugador + "!");
        } else if (puntajeMaquina >= PUNTOS_META && puntajeMaquina >= puntajeJugador) {
            System.out.println("¡HA GANADO LA MÁQUINA!");
        } else {
            System.out.println("¡EMPATE!");
        }

        return jugarOtraPartida(scanner);
    }

    // Método para el turno del jugador
    public static int turnoJugador(Scanner scanner, String nombreJugador) {
        int puntosTurno = 0;
        while (true) {
            int dado = lanzarDado();
            System.out.println("Has sacado un " + dado);
            if (dado == 6) {
                System.out.println("Has acumulado 0 puntos este turno.");
                return 0;
            }
            puntosTurno += dado;
            System.out.print("Deseas (P)lantarte o (C)ontinuar? ");
            String decision = scanner.nextLine().trim().toUpperCase();

            while (!decision.equals("P") && !decision.equals("C")) {
                System.out.print("No es una respuesta correcta. Deseas (P)lantarte o (C)ontinuar? ");
                decision = scanner.nextLine().trim().toUpperCase();
            }

            if (decision.equals("P")) {
                System.out.println("Has acumulado " + puntosTurno + " puntos este turno.");
                return puntosTurno;
            }
        }
    }

    // Método para el turno de la máquina
    public static int turnoMaquina() {
        int puntosTurno = 0;

        while (true) {
            int dado = lanzarDado();
            System.out.println("He sacado un " + dado + ".");
            if (dado == 6) {
                System.out.println("He acumulado 0 puntos este turno.");
                return 0;
            }
            puntosTurno += dado;

            if (puntosTurno >= 10) {
                System.out.println("Me planto.");
                System.out.println("He acumulado " + puntosTurno + " puntos este turno.");
                return puntosTurno;
            } else {
                System.out.println("Voy a continuar.");
            }
        }
    }

    // Método que lanza un dado (devuelve un número entre 1 y 6)
    public static int lanzarDado() {
        return 1 + (int) (Math.random() * 6);
    }

    // Pregunta si se quiere jugar otra partida
    public static boolean jugarOtraPartida(Scanner scanner) {
        System.out.print("¿Quieres jugar otra partida? (S/N) ");
        String respuesta = scanner.nextLine().trim().toUpperCase();

        while (!respuesta.equals("S") && !respuesta.equals("N")) {
            System.out.print("Respuesta no válida. ¿Quieres jugar otra partida? (S/N) ");
            respuesta = scanner.nextLine().trim().toUpperCase();
        }

        return respuesta.equals("S");
    }
}
