import java.util.Scanner;

public class chinosConMetodos {


        private int jugadorPuntos = 0; // Puntos acumulados por el jugador
        private int maquinaPuntos = 0; // Puntos acumulados por la máquina
        private boolean turnoJugador = true; // Indica si el jugador comienza en la ronda actual
        private Scanner scanner = new Scanner(System.in); // Escáner para leer la entrada del jugador

        public static void main(String[] args) {
            new chinosConMetodos().iniciarJuego(); // Crea una instancia y llama al método principal del juego
        }

        // Método principal que controla la ejecución del juego
        public void iniciarJuego() {
            while (jugadorPuntos < 5 && maquinaPuntos < 5) {
                jugarRonda(); // Jugar una ronda completa
            }
            mostrarGanadorFinal(); // Muestra el ganador final del juego
        }

        // Método que controla el flujo de una ronda de juego
        public void jugarRonda() {
            System.out.println("\n--- Nueva Ronda ---");

            // Selección de monedas por parte del jugador y la máquina
            int monedasJugador = seleccionarMonedasJugador();
            int monedasMaquina = seleccionarMonedasMaquina();
            int sumaTotal = monedasJugador + monedasMaquina; // Suma total de monedas seleccionadas

            int apuestaJugador, apuestaMaquina;

            if (turnoJugador) {
                // Si el jugador apuesta primero
                apuestaJugador = apostarJugador();
                apuestaMaquina = apostarMaquina(monedasMaquina, apuestaJugador);
                System.out.println("La máquina apuesta: " + apuestaMaquina);
            } else {
                // Si la máquina apuesta primero
                apuestaMaquina = apostarMaquina(monedasMaquina, -1);
                System.out.println("La máquina apuesta: " + apuestaMaquina);
                apuestaJugador = apostarJugador();
            }

            System.out.println("Suma total de monedas: " + sumaTotal); // Muestra la suma total de monedas
            determinarGanador(apuestaJugador, apuestaMaquina, sumaTotal); // Determina el ganador de la ronda
            turnoJugador = !turnoJugador; // Cambia el turno para la siguiente ronda
        }

        // Método para que el jugador seleccione una cantidad de monedas entre 0 y 3
        public int seleccionarMonedasJugador() {
            int monedas;
            do {
                System.out.print("Selecciona tus monedas (0-3): ");
                monedas = scanner.nextInt(); // Lee la entrada del jugador
            } while (monedas < 0 || monedas > 3); // Asegura que la entrada esté dentro del rango válido
            return monedas;
        }

        // Método para que la máquina seleccione aleatoriamente una cantidad de monedas entre 0 y 3
        public int seleccionarMonedasMaquina() {
            return (int) (Math.random() * 4); // Genera un número aleatorio entre 0 y 3
        }

        // Método para que el jugador haga su apuesta
        public int apostarJugador() {
            int apuesta;
            do {
                System.out.print("Apuesta la suma total de monedas (0-6): ");
                apuesta = scanner.nextInt(); // Lee la apuesta del jugador
            } while (apuesta < 0 || apuesta > 6); // Asegura que la apuesta esté dentro del rango válido
            return apuesta;
        }

        // Método para que la máquina haga su apuesta
        public int apostarMaquina(int monedasMaquina, int apuestaJugador) {
            int apuesta;
            do {
                // La máquina genera una apuesta que sea válida y diferente a la del jugador
                apuesta = monedasMaquina + (int) (Math.random() * (7 - monedasMaquina));
            } while (apuesta == apuestaJugador); // Asegura que la máquina no haga la misma apuesta que el jugador
            return apuesta;
        }

        // Método para determinar el ganador de una ronda
        public void determinarGanador(int apuestaJugador, int apuestaMaquina, int sumaTotal) {
            if (apuestaJugador == sumaTotal && apuestaMaquina == sumaTotal) {
                System.out.println("¡Ambos acertaron! Empate.");
            } else if (apuestaJugador == sumaTotal) {
                System.out.println("¡Has acertado! Ganas la ronda.");
                jugadorPuntos++; // Incrementa el puntaje del jugador
            } else if (apuestaMaquina == sumaTotal) {
                System.out.println("La máquina ha acertado. Gana la ronda.");
                maquinaPuntos++; // Incrementa el puntaje de la máquina
            } else {
                System.out.println("Nadie acertó. Empate en esta ronda.");
            }

            // Muestra la puntuación actual
            System.out.println("Puntuación: Jugador " + jugadorPuntos + " - Máquina " + maquinaPuntos);
        }

        // Método para mostrar el ganador final del juego
        public void mostrarGanadorFinal() {
            if (jugadorPuntos == 5) {
                System.out.println("\n¡Felicidades! Has ganado el juego.");
            } else {
                System.out.println("\nLa máquina ha ganado el juego. ¡Inténtalo de nuevo!");
            }
        }
    }
