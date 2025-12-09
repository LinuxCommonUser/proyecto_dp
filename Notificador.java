package Inmueble;

public class Notificador implements Observador {

    private final String nombre;

    public Notificador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Inmueble inmueble, String mensaje) {
        System.out.println("[" + nombre + "] Notificación recibida: " + mensaje);
    }
}
