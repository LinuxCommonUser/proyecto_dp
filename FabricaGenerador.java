package Inmueble;

public class FabricaGenerador {

    public static GeneradorDocumento crear(String tipo) {

        switch (tipo.toUpperCase()) {

            case "VENTA":
                return new GeneradorContratoVenta();

            case "ALQUILER":
                return new GeneradorContratoAlquiler();

            default:
                throw new IllegalArgumentException("Tipo de documento no soportado: " + tipo);
        }
    }
}
