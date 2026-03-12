package UI;

import Exceptions.ErrorDeCreacionException;
import Exceptions.IdentificadorDuplicadoException;
import Exceptions.ObjectNotFoundException;
import Exceptions.OpcionNoValidaException;
import Modelo.DLC;
import Modelo.Juego;
import Repositorio.Coleccion;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Coleccion cole = new Coleccion();

    public Menu() {
    }

    public void menuUsuario() throws IdentificadorDuplicadoException, ErrorDeCreacionException, ObjectNotFoundException, OpcionNoValidaException {
        int i = 0;
        Scanner scanner = new Scanner(System.in);

        while(i != 7) {
            try {
                System.out.println("ELIJA UNA OPCION: \n " +
                        "1. Agregar Juego: \n " +
                        "2. Agregar Expansion: \n " +
                        "3. Modificar titulo: \n " +
                        "4. Borrar titulo\n " +
                        "5. Mostrar Listado\n " +
                        "6.Filtrar por genero \n " +
                        "7.Salir");
                i = scanner.nextInt();
                scanner.nextLine();
                int idx;
                switch (i) {
                    case 1:
                        Juego aux = this.crearJuego();
                        if (aux == null) {
                            throw new ErrorDeCreacionException("Error de creacion");
                        }

                        this.cole.agregar(aux);
                        break;
                    case 2:
                        DLC auxE = this.crearExpansion();
                        if (auxE == null) {
                            throw new ErrorDeCreacionException("Error de creacion");
                        }

                        this.cole.agregar(auxE);
                        break;
                    case 3:
                        this.cole.mostrar();
                        System.out.println("Ingrese el ID que desea modificar:");
                        idx = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ingrese que atributo desea modificar:");
                        this.cole.modificarAtributo(idx);
                        break;
                    case 4:
                        this.cole.mostrar();
                        System.out.println("Ingrese el ID que desea borrar:");
                        idx = scanner.nextInt();
                        scanner.nextLine();
                        this.cole.eliminar(this.cole.buscarPorId(idx));
                        break;
                    case 5:
                        this.cole.mostrar();
                        break;
                    case 6:
                        System.out.println("Ingrese el genero a filtrar:");
                        String genero = scanner.nextLine();
                        this.cole.filtrarXGenero(genero);
                    case 7:
                        break;
                    default:
                        throw new OpcionNoValidaException("Opcion no valida.");
                }
            } catch (OpcionNoValidaException var7) {
                OpcionNoValidaException e = var7;
                System.out.println(e.getMessage());
            } catch (Exception var8) {
                Exception e = var8;
                throw new RuntimeException(e);
            }
        }

    }

    public Juego crearJuego() {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un titulo");
        String tit = s.nextLine();
        System.out.println("Ingrese un creador");
        String cre = s.nextLine();
        System.out.println("Ingrese un genero");
        String gen = s.nextLine();
        System.out.println("Ingrese un version");
        String ver = s.nextLine();
        s.nextLine();
        Juego jue = new Juego(tit, gen, cre, ver);
        return !jue.verificarVersion(Integer.parseInt(ver)) ? null : jue;
    }

    public DLC crearExpansion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el titulo");
        String tit = scanner.nextLine();
        System.out.println("Ingrese el creador");
        String cre = scanner.nextLine();
        System.out.println("Ingrese el genero");
        String gen = scanner.nextLine();
        System.out.println("Ingrese el fecha de lanzamiento");
        String fdl = scanner.nextLine();
        DLC aux = new DLC(tit, gen, cre, fdl);
        return !aux.verificarFecha(fdl) ? null : aux;
    }
}
