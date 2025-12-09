package Inmueble;

/**
 * Estrategia: pago en cuotas con interés simple.
 * Aplica un recargo porcentual por cuota, por ejemplo 1.5% por cuota.
 */
public class PrecioCuotas implements PrecioStrategy {

    private final double interesPorCuota; // ej. 0.015 = 1.5% por cuota

    public PrecioCuotas(double interesPorCuota) {
        this.interesPorCuota = Math.max(0, interesPorCuota);
    }

    @Override
    public double calcularPrecioFinal(Inmueble inmueble, int cuotas) {
        if (cuotas <= 0) return inmueble.getPrecio();
        double base = inmueble.getPrecio();
        double recargo = base * interesPorCuota * cuotas; // interés simple
        return base + recargo;
    }

    @Override
    public String getDescripcion() {
        return String.format("Pago en %d cuotas (interés %.2f%% por cuota)", 
                1, interesPorCuota * 100).replace("1 cuotas", "en cuotas"); // descripción genérica
    }
}
