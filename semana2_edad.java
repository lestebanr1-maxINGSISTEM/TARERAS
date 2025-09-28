// Nombre del archivo: Semana2_Edad.java

// Importamos la clase Scanner para poder leer datos que ingrese el usuario
import java.util.Scanner;

public class Semana2_Edad {
    public static void main(String[] args) {
        // Creamos un objeto Scanner para leer desde el teclado
        Scanner entrada = new Scanner(System.in);

        // Declaramos una variable String para guardar el nombre del usuario
        String nombre;

        // Declaramos una variable int para guardar el año de nacimiento
        int anioNacimiento;

        // Declaramos una variable int para guardar la edad calculada
        int edad;

        // Año actual fijo (2025) según la instrucción del ejercicio
        int anioActual = 2025;

        // Pedimos el nombre al usuario
        System.out.print("Ingrese su nombre: ");
        nombre = entrada.nextLine();  // Guardamos lo que escribe el usuario

        // Pedimos el año de nacimiento
        System.out.print("Ingrese su año de nacimiento: ");
        anioNacimiento = entrada.nextInt();  // Guardamos el número que ingrese

        // Calculamos la edad con una resta (año actual - año de nacimiento)
        edad = anioActual - anioNacimiento;

        // Imprimimos el resultado en consola
        System.out.println("Hola " + nombre + ", tu edad aproximada es: " + edad + " años.");
    }
}
