package Inmueble;

/**
 * Interfaz del patrón Observer
 */
public interface Observador {
    /**
     * Método que se llamará cuando un Inmueble cambie
     * @param inmueble El inmueble que generó la notificación
     * @param mensaje Información sobre el cambio
     */
    void actualizar(Inmueble inmueble, String mensaje);
}
