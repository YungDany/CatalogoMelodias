import Control.ControlCatalogo;
import Vista.CatalogoView;
import modelo.CatalogoMelodias;

public class Main {
    public static void main(String[] args) {
        CatalogoMelodias modelo = new CatalogoMelodias();
        CatalogoView vista = new CatalogoView();
        ControlCatalogo controlador = new ControlCatalogo(vista, modelo);

        controlador.iniciar();
    }
}