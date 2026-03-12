import Exceptions.ErrorDeCreacionException;
import Exceptions.IdentificadorDuplicadoException;
import Exceptions.ObjectNotFoundException;
import Exceptions.OpcionNoValidaException;
import UI.Menu;

public class Main {
    public static void main(String[] args) throws IdentificadorDuplicadoException, OpcionNoValidaException, ObjectNotFoundException, ErrorDeCreacionException {
        Menu menu = new Menu();
        menu.menuUsuario();
    }
}