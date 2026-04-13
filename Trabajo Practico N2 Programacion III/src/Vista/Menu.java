package Vista;

import Controlador.ControladorDireccion;
import Controlador.ControladorUsuario;
import Modelo.Direccion;
import Modelo.Usuario;
import Modelo.UsuarioDAO;

import java.beans.Statement;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private ControladorUsuario controladorUsuario;
    private ControladorDireccion controladorDireccion;
    private final Scanner scanner;
    int contador = 7;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.controladorUsuario = new ControladorUsuario();
        this.controladorDireccion = new ControladorDireccion();
    }

    public void menuUI() {
        int i = 1;
        while(i != 0) {
            System.out.println("Ingrese 1 para cargar un alumno. \n" +
                               "Ingrese 2 para cargar una direccion. \n" +
                               "Ingrese 3 para mostrar la lista de alumnos y direcciones. \n" +
                               "Ingrese 4 para buscar una direccion por ID. \n" +
                               "Ingrese 5 para actualizar la edad de un usuario. \n" +
                               "Ingrese 5 para eliminar datos relacionados a un ID. \n" +
                               "Ingrese 0 para salir. \n");

            i = scanner.nextInt();
            scanner.nextLine();

            switch (i) {
                case 1:
                    pedirDatosUsuario();
                    break;
                case 2:
                    pedirDatosDireccion();
                    break;
                case 3:
                    mostrarUsuarios();
                    mostrarDirecciones();
                    break;
                case 4:
                    mostrarDireccionEspecifica();
                    break;
                case 5:
                    actualizarEdadUsuario();
                    break;
                case 6:
                    eliminarUsuario();
                    eliminarDirecciones();
                case 0:
                    break;
            }
        }
    }

    public void pedirDatosUsuario() {
        System.out.println("Ingrese el nombre del alumno: \n");
        String nombreAux = scanner.nextLine();

        System.out.println("Ingrese el apellido del alumno: \n");
        String apellidoAux = scanner.nextLine();

        int edadAux;
        do {
            System.out.println("Ingrese la edad del alumno: \n");
            edadAux = scanner.nextInt();
            scanner.nextLine();
        } while (edadAux <= 0 || edadAux > 80);

        String emailAux;
        do {
            System.out.println("Ingrese el email del alumno: \n");
            emailAux = scanner.nextLine();
        }while (!emailAux.contains("@"));

        controladorUsuario.insertar(nombreAux, apellidoAux, edadAux, emailAux);
    }

    public void pedirDatosDireccion() {
        System.out.println("Ingrese la calle: \n");
        String calleAux = scanner.nextLine();

        int alturaAux;
        System.out.println("Ingrese la altura: \n");
        alturaAux = scanner.nextInt();
        scanner.nextLine();

        int alumnoIDaux = contador++;

        controladorDireccion.insertar(calleAux, alturaAux, alumnoIDaux);
    }

    public void mostrarUsuarios() {
        System.out.println("---- LISTA DE ALUMNOS ---- \n");
        List<Usuario> listadoAlumnos = controladorUsuario.listar();

        if (listadoAlumnos == null || listadoAlumnos.isEmpty()) {
            System.out.println("No hay alumnos para mostrar o hubo un error.");

        } else {

            for (Usuario alumno : listadoAlumnos) {
                System.out.println("\n-------------------------");
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido: " + alumno.getApellido());
                System.out.println("Edad: " + alumno.getEdad());
                System.out.println("Email: " + alumno.getEmail());
                System.out.println("------------------------- \n");
            }
        }
    }

    public void mostrarDirecciones() {
        System.out.println("---- LISTA DE DIRECCIONES ---- \n");
        List<Direccion> listadoDirercciones = controladorDireccion.listar();

        if (listadoDirercciones == null || listadoDirercciones.isEmpty()) {
            System.out.println("No hay alumnos para mostrar o hubo un error.");

        } else {

            for (Direccion direccion : listadoDirercciones) {
                System.out.println("\n-------------------------");
                System.out.println("Calle: " + direccion.getCalle());
                System.out.println("Altura: " + direccion.getAltura());
                System.out.println("ID: " + direccion.getId());
                System.out.println("------------------------- \n");
            }
        }
    }

    public void mostrarDireccionEspecifica() {

        int idBuscado;
        System.out.println("Ingrese el ID que desea buscar: \n");
        idBuscado = scanner.nextInt();
        scanner.nextLine();

        List<Direccion> listadoDirercciones = controladorDireccion.listarEspecifico(idBuscado);

        if (listadoDirercciones == null || listadoDirercciones.isEmpty()) {
            System.out.println("No hay alumnos para mostrar o hubo un error.");

        } else {

            for (Direccion direccion : listadoDirercciones) {
                System.out.println("\n-------------------------");
                System.out.println("Calle: " + direccion.getCalle());
                System.out.println("Altura: " + direccion.getAltura());
                System.out.println("------------------------- \n");
            }
        }
    }

    public void actualizarEdadUsuario() {
        System.out.println("Ingrese el ID del alumno a actualizar:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Ingrese la nueva edad:");
        int nuevaEdad = scanner.nextInt();
        scanner.nextLine();

        controladorUsuario.actualizarEdadUsuario(id, nuevaEdad);
    }

    public void eliminarUsuario() {
        System.out.println("Ingrese el ID del alumno que desea eliminar: \n");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Está seguro de que desea eliminar al alumno " + id + "? (S/N)");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            controladorUsuario.eliminarUsuario(id);
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    public void eliminarDirecciones() {
        System.out.println("Ingrese el ID de la direccion que desea eliminar: \n");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("¿Está seguro de que desea eliminar la direccion enlazada al id " + id + "? (S/N)");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            controladorUsuario.eliminarUsuario(id);
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}
  