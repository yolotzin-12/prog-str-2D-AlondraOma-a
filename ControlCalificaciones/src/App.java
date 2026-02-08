import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeService gradeService = new GradeService();

        String nombre = leerTextoNoVacio(sc, "Ingresa el nombre del alumno:");

        double p1 = leerDoubleEnRango(sc, "Parcial 1:", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2:", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3:", 0, 100);

        int asistencia = leerIntEnRango(sc, "Asistencia (%):", 0, 100);

        boolean entregoProyecto = leerBoolean(sc, "¿Entregó proyecto?");

        double promedio = gradeService.calcularPromedio(p1, p2, p3);
        double finalCal = gradeService.calcularFinal(promedio, asistencia);
        String estado = gradeService.determinarEstado(finalCal, asistencia, entregoProyecto);

        imprimirReporte(
                nombre,
                p1, p2, p3,
                promedio,
                asistencia,
                entregoProyecto,
                finalCal,
                estado
        );
    }


    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;

        while (true) {
            System.out.println(msg);
            texto = sc.nextLine();

            if (!texto.trim().isEmpty()) {
                return texto;
            }

            System.out.println("El texto no puede estar vacío");
        }
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double value;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextDouble()) {
                value = sc.nextDouble();
                sc.nextLine();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Valor fuera de rango");
            } else {
                System.out.println("No es un número válido");
                sc.next();
            }
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int value;

        while (true) {
            System.out.println(msg);

            if (sc.hasNextInt()) {
                value = sc.nextInt();
                sc.nextLine();

                if (value >= min && value <= max) {
                    return value;
                }

                System.out.println("Valor fuera de rango");
            } else {
                System.out.println("No es un entero válido");
                sc.next();
            }
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg + " (true/false)");

            if (sc.hasNextBoolean()) {
                boolean value = sc.nextBoolean();
                sc.nextLine();
                return value;
            } else {
                System.out.println("Solo se acepta true o false");
                sc.next();
            }
        }
    }

    public static void imprimirReporte(
            String nombre,
            double p1, double p2, double p3,
            double promedio,
            int asistencia,
            boolean entregoProyecto,
            double finalCal,
            String estado
    ) {
        System.out.println("Alumno: " + nombre);
        System.out.println("Parcial 1: " + p1);
        System.out.println("Parcial 2: " + p2);
        System.out.println("Parcial 3: " + p3);
        System.out.println("Promedio parciales: " + promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entregó proyecto: " + (entregoProyecto ? "SI" : "NO"));
        System.out.println("Calificación final: " + finalCal);
        System.out.println("Estado: " + estado);

    }
}
