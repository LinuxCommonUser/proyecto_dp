package Inmueble;

/** Estrategia: pago al contado (sin cambios) */
public class PrecioContado implements PrecioStrategy {

    @Override
    public double calcularPrecioFinal(Inmueble inmueble, int cuotas) {
        return inmueble.getPrecio();
    }

    @Override
    public String getDescripcion() {
        return "Pago al contado (sin recargo)";
    }
}
