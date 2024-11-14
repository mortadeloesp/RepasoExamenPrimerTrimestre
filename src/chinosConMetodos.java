import java.util.Scanner;

public class chinosConMetodos {


    // Variables para almacenar los puntos del jugador y de la máquina
    private int jugadorPuntos = 0;
    private int maquinaPuntos = 0;
    private boolean turnoJugador = true; // Alterna el turno: true si empieza el jugador, false si empieza la máquina
    private Scanner scanner = new Scanner(System.in); // Scanner para leer la entrada del usuario

    public static void main(String[] args) {
        new chinosConMetodos().iniciarJuego(); // Inicia el juego llamando al método principal
    }

    // Método principal que controla la ejecución del juego hasta que alguien gane 5 rondas
    private void iniciarJuego() {
        while (jugadorPuntos < 5 && maquinaPuntos < 5) {
            jugarRonda(); // Se juega una ronda
        }
        mostrarGanadorFinal(); // Muestra el ganador final cuando alguien alcanza 5 puntos
    }

    // Método para jugar una ronda completa
    private void jugarRonda() {
        System.out.println("\n--- Nueva Ronda ---");

        // Selección de monedas por parte del jugador y la máquina
        int monedasJugador = seleccionarMonedasJugador();
        int monedasMaquina = seleccionarMonedasMaquina();
        int sumaTotal = monedasJugador + monedasMaquina; // Suma total de las monedas elegidas por ambos

        int apuestaJugador, apuestaMaquina;

        if (turnoJugador) {
            // Si es el turno del jugador de apostar primero
            apuestaJugador = apostarJugador();
            apuestaMaquina = apostarMaquina(monedasMaquina, apuestaJugador);
            System.out.println("La máquina apuesta: " + apuestaMaquina); // Muestra la apuesta de la máquina
        } else {
            // Si es el turno de la máquina de apostar primero
            apuestaMaquina = apostarMaquina(monedasMaquina, -1);
            System.out.println("La máquina apuesta: " + apuestaMaquina); // Muestra la apuesta de la máquina
            apuestaJugador = apostarJugador(); // Luego apuesta el jugador
        }

        // Se muestra la suma total de monedas seleccionadas por ambos
        System.out.println("Suma total de monedas: " + sumaTotal);

        // Determina quién ganó la ronda
        determinarGanador(apuestaJugador, apuestaMaquina, sumaTotal);

        // Cambia el turno para la próxima ronda
        turnoJugador = !turnoJugador;
    }

    // Método para que el jugador seleccione una cantidad de monedas entre 0 y 3
    private int seleccionarMonedasJugador() {
        int monedas;
        do {
            System.out.print("Selecciona tus monedas (0-3): ");
            monedas = scanner.nextInt(); // Lee la entrada del jugador
        } while (monedas < 0 || monedas > 3); // Valida que la entrada esté entre 0 y 3
        return monedas; // Devuelve la cantidad de monedas seleccionada
    }

    // Método para que la máquina seleccione aleatoriamente una cantidad de monedas entre 0 y 3
    private int seleccionarMonedasMaquina() {
        return (int) (Math.random() * 4); // Genera un número aleatorio entre 0 y 3
    }

    // Método para que el jugador apueste la suma total de monedas entre ambos
    private int apostarJugador() {
        int apuesta;
        do {
            System.out.print("Apuesta la suma total de monedas (0-6): ");
            apuesta = scanner.nextInt(); // Lee la apuesta del jugador
        } while (apuesta < 0 || apuesta > 6); // Valida que la apuesta esté entre 0 y 6
        return apuesta; // Devuelve la apuesta del jugador
    }

    // Método para que la máquina haga una apuesta
    private int apostarMaquina(int monedasMaquina, int apuestaJugador) {
        int apuesta;
        do {
            // Genera una apuesta aleatoria mayor o igual a las monedas que eligió la máquina
            apuesta = monedasMaquina + (int) (Math.random() * (7 - monedasMaquina));
        } while (apuesta == apuestaJugador); // Asegura que la máquina no apueste lo mismo que el jugador
        return apuesta; // Devuelve la apuesta de la máquina
    }

    // Método para determinar el ganador de la ronda
    private void determinarGanador(int apuestaJugador, int apuestaMaquina, int sumaTotal) {
        if (apuestaJugador == sumaTotal && apuestaMaquina == sumaTotal) {
            // Ambos acertaron
            System.out.println("¡Ambos acertaron! Empate.");
        } else if (apuestaJugador == sumaTotal) {
            // El jugador acertó
            System.out.println("¡Has acertado! Ganas la ronda.");
            jugadorPuntos++; // Incrementa el puntaje del jugador
        } else if (apuestaMaquina == sumaTotal) {
            // La máquina acertó
            System.out.println("La máquina ha acertado. Gana la ronda.");
            maquinaPuntos++; // Incrementa el puntaje de la máquina
        } else {
            // Ninguno acertó
            System.out.println("Nadie acertó. Empate en esta ronda.");
        }

        // Muestra la puntuación actual
        System.out.println("Puntuación: Jugador " + jugadorPuntos + " - Máquina " + maquinaPuntos);
    }

    // Método para mostrar el ganador final del juego
    private void mostrarGanadorFinal() {
        if (jugadorPuntos == 5) {
            System.out.println("\n¡Felicidades! Has ganado el juego.");
        } else {
            System.out.println("\nLa máquina ha ganado el juego. ¡Inténtalo de nuevo!");
        }
    }
}
