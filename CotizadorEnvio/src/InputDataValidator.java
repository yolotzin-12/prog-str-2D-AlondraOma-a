import java.util.Scanner;

public class InputDataValidator {

    public int getValidInt(Scanner scanner, String msg) {
        System.out.println(msg);
        return scanner.nextInt();
    }

    public double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double value;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextDouble()) {
                value = sc.nextDouble();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("El valor esta fuera de rango de " + min + " a " + max);
            } else {
                System.out.println("No es un dato numerico");
                sc.next();
            }
        }
    }

    public int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int value;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextInt()) {
                value = sc.nextInt();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("El valor esta fuera de rango de " + min + " a " + max);
            } else {
                System.out.println("No es un dato numerico");
                sc.next();
            }
        }
    }

    public boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg + " (true/false)");

            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("No es un valor booleano");
                sc.next();
            }
        }
    }
}
