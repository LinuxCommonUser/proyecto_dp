package Inmueble;

public class GeneradorContratoAlquiler extends GeneradorDocumento {

    @Override
    protected Documento crearDocumento() {
        return new ContratoAlquiler();
    }
}
