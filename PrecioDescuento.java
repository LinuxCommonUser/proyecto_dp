package Inmueble;

/** Estrategia: aplica un descuento porcentual fijo */
public class PrecioDescuento implements PrecioStrategy {

    private final double descuento; // 0.10 = 10%

    public PrecioDescuento(double descuento) {
        this.descuento = Math.max(0, Math.min(descuento, 1.0));
    }

    @Override
    public double calcularPrecioFinal(Inmueble inmueble, int cuotas) {
        double base = inmueble.getPrecio();
        return base * (1 - descuento);
    }

    @Override
    public String getDescripcion() {
        return String.format("Descuento %.2f%%", descuento * 100);
    }
}
