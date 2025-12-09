package Inmueble;

/**
 * Strategy: cálculo del precio final según la forma de pago o cuotas.
 */
public interface PrecioStrategy {
    
    double calcularPrecioFinal(Inmueble inmueble, int cuotas);

    /**
     * Descripción corta de la estrategia (para mostrar al usuario).
     */
    String getDescripcion();
}
