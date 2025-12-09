package Inmueble;

public class GeneradorContratoVenta extends GeneradorDocumento {

    @Override
    protected Documento crearDocumento() {
        return new ContratoVenta();
    }
}
