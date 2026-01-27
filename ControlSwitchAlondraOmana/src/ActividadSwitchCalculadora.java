import java.util.Scanner;

public class ActividadSwitchCalculadora {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");

        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();

        System.out.print("Ingresa el valor de a: ");
        double a = scanner.nextDouble();

        System.out.print("Ingresa el valor de b: ");
        double b = scanner.nextDouble();

        double resultado;

        switch (opcion) {
            case 1:
                resultado = a + b;
                System.out.println("Operación: Sumar");
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 2:
                resultado = a - b;
                System.out.println("Operación: Restar");
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 3:
                resultado = a * b;
                System.out.println("Operación: Multiplicar");
                System.out.println("Valores: a = " + a + ", b = " + b);
                System.out.println("Resultado: " + resultado);
                break;

            case 4:
                System.out.println("Operación: Dividir");
                System.out.println("Valores: a = " + a + ", b = " + b);

                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    System.out.println("Resultado: " + resultado);
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }
    }
}
