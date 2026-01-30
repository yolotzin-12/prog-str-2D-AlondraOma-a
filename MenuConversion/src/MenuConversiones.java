import java.util.Scanner;

public class MenuConversiones {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;
        boolean salir = false;

        int celsiusAFahrenheit = 0;
        int fahrenheitACelsius = 0;
        int kmAMillas = 0;
        int millasAKm = 0;

        do {
            System.out.println("\n--- MENU DE CONVERSIONES ---");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Elige una opcion: ");


            if (!sc.hasNextInt()) {
                System.out.println("Opcion invalida. Debe ser un numero.");
                sc.next();
                continue;
            }

            opcion = sc.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opcion fuera de rango (1-5).");
                continue;
            }

            switch (opcion) {
                case 1: {
                    double celsius = leerDouble(sc, "Ingresa grados Celsius: ");
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.println("Resultado: " + fahrenheit + " °F");
                    celsiusAFahrenheit++;
                    break;
                }
                case 2: {
                    double fahrenheit = leerDouble(sc, "Ingresa grados Fahrenheit: ");
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    System.out.println("Resultado: " + celsius + " °C");
                    fahrenheitACelsius++;
                    break;
                }
                case 3: {
                    double km = leerDouble(sc, "Ingresa kilometros: ");
                    double millas = km * 0.621371;
                    System.out.println("Resultado: " + millas + " millas");
                    kmAMillas++;
                    break;
                }
                case 4: {
                    double millas = leerDouble(sc, "Ingresa millas: ");
                    double km = millas / 0.621371;
                    System.out.println("Resultado: " + km + " km");
                    millasAKm++;
                    break;
                }
                case 5:
                    salir = true;
                    break;
            }

        } while (!salir);

        int total = celsiusAFahrenheit + fahrenheitACelsius + kmAMillas + millasAKm;

        System.out.println("\n--- RESUMEN ---");
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + celsiusAFahrenheit);
        System.out.println("°F a °C: " + fahrenheitACelsius);
        System.out.println("Km a Millas: " + kmAMillas);
        System.out.println("Millas a Km: " + millasAKm);

        sc.close();
    }

    public static double leerDouble(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            } else {
                System.out.println("Dato invalido. Debe ser numerico.");
                sc.next();
            }
        }
    }
}
