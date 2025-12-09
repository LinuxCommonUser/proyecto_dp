package Inmueble;

/**
 * Patrón State
 */
public interface EstadoInmueble {

    void mostrarEstado();
    boolean puedeVender();
    boolean puedeReservar();

    // Clases internas 

    class Disponible implements EstadoInmueble {
        @Override
        public void mostrarEstado() {
            System.out.println("El inmueble está disponible.");
        }
        @Override
        public boolean puedeVender() {
            return true;
        }
        @Override
        public boolean puedeReservar() {
            return true;
        }
    }
    class Reservado implements EstadoInmueble {
        @Override
        public void mostrarEstado() {
            System.out.println("El inmueble está reservado.");
        }
        @Override
        public boolean puedeVender() {
            return true; // si quieres permitir venta mientras está reservado
        }
        @Override
        public boolean puedeReservar() {
            return false;
        }
    }
    class Vendido implements EstadoInmueble {
        @Override
        public void mostrarEstado() {
            System.out.println("El inmueble ha sido vendido.");
        }
        @Override
        public boolean puedeVender() {
            return false;
        }
        @Override
        public boolean puedeReservar() {
            return false;
        }
    }
}
