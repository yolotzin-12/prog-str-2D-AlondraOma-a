import java.util.Scanner;
public class Main {
     public static double RANGO_BAJO=18.5;
     public static double RANGO_MEDIO=25;
     public static double RANGO_ALTO=30;
     public static final double PI=3.14.16;
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
                     double pesoKg = obtenerDouble(scanner, "Ingresa el peso em kilogramos");
                     double alturaM = obtenerDouble(scanner,"Ingrese la altura: ");
                     double imc = CalcularImc(pesoKg,alturaM);
                     System.out.println("Tu IMC es de: " +imc);
                     System.out.println("Clasificacion: " + ObtenerClasificacion(imc) );
                     break;
                 case 2:
                     System.out.println("SELECCIONASTE AREA DE UN CIRCULO");
                     double radio = obtenerCirculo(scanner,"Ingresa el radio del circulo: ");
                     double area = CalcularArea(radio);
                     System.out.println("El area del circulo es: " + area);
                     break;
                 case 3:
                     System.out.println("SELECCIONASTE CONVERTIR DE °C A °F");
                     break;
                 case 4:
                     System.out.println("SELECCIONASTE AREA DE UN RECTANGULO");
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
      * Metodo para capturar
      * @param sc -> Previamente instanciado desde el main
      * @param mensaje -> String enviado como parametro
      * @return double
      */
     public static double obtenerCirculo(Scanner sc, String mensaje){
         System.out.println(mensaje);
         return sc.nextDouble();
     }

     /**
      *
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

     /**
      * Metodo usado para obtener una clasificacion del IMC, segun las reglas de negocio
      * @param imc -> previamente calculado
      * @return -> String de calificacion en relacion al imc
      */
     public static String ObtenerClasificacion(double imc){
         if(imc<18.5) return "Bajo de peso";
         else if(imc<25) return "Peso medio";
         else if(imc<30)  return "Sobre peso";
         else return "Obesidad";

     }
    }
