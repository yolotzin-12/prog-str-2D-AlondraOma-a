import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        InputDataValidator inputDataValidator = new InputDataValidator();

        double pesoKg = inputDataValidator.leerDoubleEnRango(sc, "Ingresa el peso en kg:", 0.1, 50.0);
        int distanciaKm = inputDataValidator.leerIntEnRango(sc, "Ingresa la distancia en km:", 1, 2000);
        int tipoServicio = inputDataValidator.leerIntEnRango(sc, "Ingresa el tipo de servicio (1 = Estandar, 2 = Express):", 1, 2);

        boolean esZonaRemota = inputDataValidator.leerBoolean(sc, "¿Es zona remota?");
        ShippingCalculator calculator = new ShippingCalculator();

        double subtotal = calculator.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);

        double iva = calculator.calcularIVA(subtotal);
        double total = calculator.calcularTotal(subtotal, iva);

        imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota, subtotal, iva, total);
    }

    public static void imprimirTicket(double pesoKg, int distanciaKm, int tipoServicio, boolean esZonaRemota, double subtotal, double iva, double total) {

        String servicio;
        if (tipoServicio == 1) {
            servicio = "Estandar";
        } else {
            servicio = "Express";
        }

        System.out.println("----- TICKET DE ENVIO -----");
        System.out.println("Servicio: " + servicio);
        System.out.println("Peso: " + pesoKg + " kg");
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Zona remota: " + (esZonaRemota ? "SI" : "NO"));
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("IVA (16%): $" + iva);
        System.out.println("TOTAL: $" + total);
        System.out.println("---------------------------");
    }
}
