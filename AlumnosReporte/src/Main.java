import java.util.Scanner;

public class Main {

    static Alumno[] alumnos = new Alumno[25];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n---- MENU ----");
            System.out.println("1) Alta de alumno");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Actualizar promedio por ID");
            System.out.println("4) Baja logica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    altaAlumno();
                    break;
                case 2:
                    buscarAlumno();
                    break;
                case 3:
                    actualizarPromedio();
                    break;
                case 4:
                    bajaLogica();
                    break;
                case 5:
                    listarActivos();
                    break;
                case 6:
                    reportes();
                    break;
                case 0:
                    System.out.println("Saliendo del menú...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }


    static void altaAlumno() {

        int id;
        String nombre;
        double promedio;

        System.out.print("ID (Introduce un ID mayor a cero): ");
        id = sc.nextInt();

        if (id <= 0) {
            System.out.println("ID inválido");
            return;
        }

        if (buscarPorIdRegistrado(id) != -1) {
            System.out.println("ID repetido");
            return;
        }

        sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();

        if (nombre.isEmpty()) {
            System.out.println("Nombre vacío");
            return;
        }

        System.out.print("Promedio (0-10): ");
        promedio = sc.nextDouble();

        if (promedio < 0 || promedio > 10) {
            System.out.println("Promedio inválido");
            return;
        }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nombre, promedio);
                System.out.println("Alumno registrado");
                return;
            }
        }

        System.out.println("Arreglo lleno");
    }

    static int buscarPorIdRegistrado(int id) {
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    static void buscarAlumno() {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();

        int posicion = buscarPorIdRegistrado(id);

        if (posicion != -1 && alumnos[posicion].activo) {
            System.out.println("ID: " + alumnos[posicion].id);
            System.out.println("Nombre: " + alumnos[posicion].nombre);
            System.out.println("Promedio: " + alumnos[posicion].promedio);
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    static void actualizarPromedio() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int posicion = buscarPorIdRegistrado(id);

        if (posicion != -1 && alumnos[posicion].activo) {
            System.out.print("Nuevo promedio (0-10): ");
            double nuevo = sc.nextDouble();

            if (nuevo >= 0 && nuevo <= 10) {
                alumnos[posicion].promedio = nuevo;
                System.out.println("Promedio actualizado");
            } else {
                System.out.println("Promedio inválido");
            }
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    static void bajaLogica() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        int pos = buscarPorIdRegistrado(id);

        if (pos != -1 && alumnos[pos].activo) {
            alumnos[pos].activo = false;
            System.out.println("Alumno dado de baja");
        } else {
            System.out.println("Alumno no encontrado o inactivo");
        }
    }

    static void listarActivos() {
        for (Alumno a : alumnos) {
            if (a != null && a.activo) {
                System.out.println("ID: " + a.id +
                        " | Nombre: " + a.nombre +
                        " | Promedio: " + a.promedio);
            }
        }
    }

    static void reportes() {

        double suma = 0;
        int contador = 0;
        Alumno mayorcalificacion = null;
        Alumno menorcalificacion = null;
        int mayoresa8 = 0;

        for (Alumno a : alumnos) {
            if (a != null && a.activo) {

                suma += a.promedio;
                contador++;

                if (mayorcalificacion == null || a.promedio > mayorcalificacion.promedio) {
                    mayorcalificacion = a;
                }

                if (menorcalificacion == null || a.promedio < menorcalificacion.promedio) {
                    menorcalificacion = a;
                }

                if (a.promedio >= 8.0) {
                    mayoresa8++;
                }
            }
        }

        if (contador == 0) {
            System.out.println("No hay alumnos dados de alta");
            return;
        }

        System.out.println("Promedio general: " + (suma / contador));

        System.out.println("----Alumno con mayor calificacion----");
        System.out.println("ID: " + mayorcalificacion.id);
        System.out.println(" Nombre: " + mayorcalificacion.nombre);
        System.out.println(" Promedio: " + mayorcalificacion.promedio);

        System.out.println("----Alumno con menor calificacion----");
        System.out.println("ID: " + menorcalificacion.id +
                " Nombre: " + menorcalificacion.nombre +
                " Promedio: " + menorcalificacion.promedio);

        System.out.println("Alumnos con promedio mayor a 8: " + mayoresa8);
    }
}