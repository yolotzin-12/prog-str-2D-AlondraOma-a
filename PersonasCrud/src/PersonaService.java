import java.util.Scanner;

public class PersonaService {

    public void alta(Scanner sc, Persona[] personas) {

        InputValidator input = new InputValidator();
        int id = input.getIntNumber(sc, "Ingresa el id: ");

        if (id <= 0) {
            System.out.println("El id debe ser mayor a 0");
            return;
        }

        if (existeId(personas, id)) {
            System.out.println("Ese id ya existe");
            return;
        }

        System.out.print("Ingresa el nombre: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Nombre no valido");
            return;
        }

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new Persona(id, name);
                System.out.println("Alta exitosa");
                return;
            }
        }

        System.out.println("No hay espacio disponible");
    }

    public void buscarPorId(Scanner sc, Persona[] personas) {

        InputValidator input = new InputValidator();
        int id = input.getIntNumber(sc, "Ingresa el id a buscar: ");

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isSctive()) {
                System.out.println(p);
                return;
            }
        }

        System.out.println("Persona no encontrada o inactiva");
    }

    public void bajaLogica(Scanner sc, Persona[] personas) {

        InputValidator input = new InputValidator();
        int id = input.getIntNumber(sc, "Ingresa el id a dar de baja: ");

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isSctive()) {
                p.setSctive(false);
                System.out.println("Baja logica realizada");
                return;
            }
        }

        System.out.println("Persona no encontrada o ya inactiva");
    }

    public void listarActivas(Persona[] personas) {

        boolean hay = false;

        for (Persona p : personas) {
            if (p != null && p.isSctive()) {
                System.out.println(p);
                hay = true;
            }
        }

        if (!hay) {
            System.out.println("No hay personas activas");
        }
    }

    public void actualizarNombre(Scanner sc, Persona[] personas) {

        InputValidator input = new InputValidator();
        int id = input.getIntNumber(sc, "Ingresa el id: ");

        for (Persona p : personas) {
            if (p != null && p.getId() == id && p.isSctive()) {

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = sc.nextLine();

                if (nuevoNombre.trim().isEmpty()) {
                    System.out.println("Nombre no valido");
                    return;
                }

                p.setName(nuevoNombre);
                System.out.println("Nombre actualizado");
                return;
            }
        }

        System.out.println("Persona no encontrada o inactiva");
    }

    private boolean existeId(Persona[] personas, int id) {
        for (Persona p : personas) {
            if (p != null && p.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
