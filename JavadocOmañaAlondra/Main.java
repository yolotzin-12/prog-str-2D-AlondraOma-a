import java.util.Scanner;
public class Main {
    public static final double PI = 3.1416;
    public static void main(String[] args) {
         Scanner scanner= new Scanner(System.in);
         int choice;
         do {

             System.out.println("Menu:");
             System.out.println("1. IMC");
             System.out.println("2. AREA DE UN CIRCULO");
             System.out.println("3. CONVERTIR DE °C A °F");
             System.out.println("4. AREA DE UN RECTANGULO");
             System.out.println("5. SALIR");


             choice = scanner.nextInt();
             switch (choice) {
                 case 1:
                     System.out.println("SELECCIONASTE IMC");
                     double pesoKg = obtenerDouble(scanner, "Ingresa el peso en kilogramos");
                     double alturaM = obtenerDouble(scanner,"Ingrese la altura: ");
                     double imc = CalcularImc(pesoKg,alturaM);
                     System.out.println("Tu IMC es de: " +imc);
                     break;
                 case 2:
                     System.out.println("SELECCIONASTE AREA DE UN CIRCULO");
                     double radio = obtenerCirculo(scanner,"Ingresa el radio del circulo: ");
                     double area = CalcularArea(radio);
                     System.out.println("El area del circulo es: " + area);
                     break;
                 case 3:
                     System.out.println("SELECCIONASTE CONVERTIR DE °C A °F");
                     double celsius = obtenerCaF(scanner,"Ingresa los grados celsius: ");
                     double fahrenheit = calcularCaF(celsius);
                     System.out.println("El equivalente en Fahrenheit es: " + fahrenheit + " °F");
                     break;
                 case 4:
                     System.out.println("SELECCIONASTE AREA DE UN RECTANGULO");
                     double base = obtenerRectangulo(scanner,"Ingresa la base del rectangulo: ");
                     double alturaRectangulo = obtenerRectangulo(scanner,"Ingresa la altura del rectangulo: ");
                     double arearectangulo = calcularRectangulo(base,alturaRectangulo);
                     System.out.println("El area del rectangulo es: " + arearectangulo);
                     break;
                 case 5:
                     System.out.println("SALISTE DEL PROGRAMA");
                     break;
                 default:
                     System.out.println("NUMERO INVALIDO, INTENTA DE NUEVO");
             }
             System.out.println();

         } while (choice != 5);


     }

    /**
     * Metodo para capturar los grados a celsius
     * @param sc -> Previamente instanciado desde el main
     * @param mensaje -> String enviado como parametro
     * @return double
     */
     public static double obtenerCaF(Scanner sc, String mensaje){
         System.out.println(mensaje);
         return sc.nextDouble();
     }

    /**
     * Metodo para convertir de grados a celsius
     * @param celsius -> Temperatura en grados celsius
     * @return double
     */
     public static double calcularCaF(double celsius){
        return (celsius * 1.8) + 32;
    }


    /**
     * Metodo para calcular el area del rectangulo
     * @param base -> Base del rectangulo
     * @param alturaRectangulo -> Altura del rectangulo
     * @return double
     */
     public static double calcularRectangulo(double base, double alturaRectangulo){
        return base*alturaRectangulo;
     }


    /**
     *Metoodo para calcular el area de un rectangulo
     * @param sc -> Previamente instanciado desde el main
     * @param mensaje -> String enviado como parametro
     * @return double
     */
     public static double obtenerRectangulo(Scanner sc, String mensaje){
         System.out.println(mensaje);
         return sc.nextDouble();
     }


     /**
      * Metodo para capturar el area del circulo
      * @param sc -> Previamente instanciado desde el main
      * @param mensaje -> String enviado como parametro
      * @return double
      */
     public static double obtenerCirculo(Scanner sc, String mensaje){
         System.out.println(mensaje);
         return sc.nextDouble();
     }

     /**
      *Metodo para calcular el area del circulo
      * @param radio -> radio del circulo
      * @return double
      */
     public static double CalcularArea(double radio){
         return PI * radio * radio;
     }


     /**
      * Metodo para capturar un double desde consola
      * @param sc -> Previamente instanciado desde el main
      * @param mensaje -> String enviado como parametro
      * @return double
      */
     public static double obtenerDouble(Scanner sc, String mensaje){
         System.out.println(mensaje);
         return sc.nextDouble();
     }


     /**
      * Metodo para calcular IMC usando la formula pesoKg/altura²
      * @param pesoKG -> expresado en kilogramos
      * @param alturaM -> expresado en metros
      * @return double
      */
     public static double CalcularImc(double pesoKG, double alturaM){

         return pesoKG/(alturaM*alturaM);
     }


    }
