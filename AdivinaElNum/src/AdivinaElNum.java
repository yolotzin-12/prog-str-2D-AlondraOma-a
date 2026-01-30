import java.util.Random;
import java.util.Scanner;

public class AdivinaElNum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int secreto = random.nextInt(100) + 1;

        int intentos = 0;
        int limiteIntentos = 7;
        boolean gano = false;

        int[] contadores = new int[2];


        System.out.println("Adivina el numero secreto (1-100)");

        while (intentos < limiteIntentos) {

            int numero = obtenerNumeroValido(sc, "Intento " + (intentos + 1) + ":", min, max, contadores);

            intentos++;

            if (numero == secreto) {
                System.out.println("¡Ganaste! Adivinaste en el intento " + intentos);
                gano = true;
                break;
            } else if (numero > secreto) {
                System.out.println("El numero secreto es menor");
            } else {
                System.out.println("El numero secreto es mayor");
            }
        }

        if (!gano) {
            System.out.println("Perdiste El numero secreto era: " + secreto);
        }

        System.out.println("\n--- Estadisticas ---");
        System.out.println("Entradas fuera de rango: " + contadores[0]);
        System.out.println("Entradas no numericas: " + contadores[1]);

        sc.close();
    }

    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max, int[] contadores) {

        int valor;

        while (true) {
            System.out.println(mensaje);

            if (sc.hasNextInt()) {
                valor = sc.nextInt();

                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.println("Numero fuera de rango (1-100)");
                    contadores[0]++;
                }
            } else {
                System.out.println("Entrada no numerica");
                contadores[1]++;
                sc.next();
            }
        }
    }
}
