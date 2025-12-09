package Inmueble;

public class ObservadorConsola implements Observador {
    private final String nombre;

    public ObservadorConsola(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Inmueble inmueble, String mensaje) {
        System.out.println("[" + nombre + "] Notificación recibida: " + mensaje +
                " (Inmueble: " + inmueble.getDireccion() + ")");
    }
}
