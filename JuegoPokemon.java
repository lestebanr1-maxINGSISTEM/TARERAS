import java.util.*;

class Pokemon {
    String nombre;
    int hp;
    String[] ataques;

    public Pokemon(String nombre, int hp, String[] ataques) {
        this.nombre = nombre;
        this.hp = hp;
        this.ataques = ataques;
    }

    public boolean estaVivo() {
        return hp > 0;
    }
}

public class JuegoPokemon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear los Pokémon iniciales
        Pokemon[] iniciales = {
            new Pokemon("Charmander", 100, new String[]{"Arañazo", "Ascuas de fuego"}),
            new Pokemon("Squirtle", 100, new String[]{" Placaje ", " Pistola Agua "}),
            new Pokemon("Bulbasaur", 100, new String[]{"Placaje", "Látigo Cepa"}),
            new Pokemon("Pikachu", 100, new String[]{"Impactrueno", "Placaje"})
        };

        // Mostrar opciones al jugador
        System.out.println("Elige tu Pokémon:");
        for (int i = 0; i < iniciales.length; i++) {
            System.out.println((i + 1) + ". " + iniciales[i].nombre);
        }
        int eleccion = sc.nextInt() - 1;
        Pokemon jugador = iniciales[eleccion];

        // CPU elige uno diferente
        Random rand = new Random();
        int eleccionCPU;
        do {
            eleccionCPU = rand.nextInt(iniciales.length);
        } while (eleccionCPU == eleccion);
        Pokemon cpu = iniciales[eleccionCPU];

        System.out.println("Tú eliges a " + jugador.nombre + "!");
        System.out.println("La CPU elige a " + cpu.nombre + "!");
        System.out.println("¡Comienza la batalla!\n");

        // Batalla por turnos
        while (jugador.estaVivo() && cpu.estaVivo()) {
            // Turno del jugador
            System.out.println("Elige un ataque:");
            for (int i = 0; i < jugador.ataques.length; i++) {
                System.out.println((i + 1) + ". " + jugador.ataques[i]);
            }
            int atkJugador = sc.nextInt() - 1;

            // CPU elige ataque al azar
            int atkCPU = rand.nextInt(cpu.ataques.length);

            // Daño simple aleatorio (10 a 20)
            int dañoJugador = 10 + rand.nextInt(11);
            int dañoCPU = 10 + rand.nextInt(11);

            cpu.hp -= dañoJugador;
            jugador.hp -= dañoCPU;

            System.out.println(jugador.nombre + " usa " + jugador.ataques[atkJugador] +
                    " y hace " + dañoJugador + " de daño.");
            System.out.println(cpu.nombre + " usa " + cpu.ataques[atkCPU] +
                    " y hace " + dañoCPU + " de daño.");

            System.out.println("HP de " + jugador.nombre + ": " + Math.max(jugador.hp, 0));
            System.out.println("HP de " + cpu.nombre + ": " + Math.max(cpu.hp, 0));
            System.out.println("----------------------------");
        }

        // Resultado final
        if (jugador.estaVivo()) {
            System.out.println("¡Ganaste la batalla!");
        } else {
            System.out.println("Perdiste... " + cpu.nombre + " ganó.");
        }
    }
}
