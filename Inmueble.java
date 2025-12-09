package Inmueble;

public class Inmueble {
    // Atributos (final)
    private final String direccion;
    private final double precio;
    private final int habitaciones;
    private final int banos;
    // Opcionales
    private final boolean tieneGarage;
    private final boolean tienePiscina;
    private final String descripcion;
    // opcional: cuotas (puedes usarlo o seguir imprimiendo desde main)
    private final int cuotas;

    // Constructor privado, solo el Builder puede llamarlo
    private Inmueble(InmuebleBuilder builder) {
        this.direccion = builder.direccion;
        this.precio = builder.precio;
        this.habitaciones = builder.habitaciones;
        this.banos = builder.banos;
        this.tieneGarage = builder.tieneGarage;
        this.tienePiscina = builder.tienePiscina;
        this.descripcion = builder.descripcion;
        this.cuotas = builder.cuotas;
    }

    // Getters
    public String getDireccion() { return direccion; }
    public double getPrecio() { return precio; }
    public int getHabitaciones() { return habitaciones; }
    public int getBanos() { return banos; }
    public boolean getTieneGarage() { return tieneGarage; }
    public boolean getTienePiscina() { return tienePiscina; }
    public String getDescripcion() { return descripcion; }
    public int getCuotas() { return cuotas; }

    // Builder estático anidado
    public static class InmuebleBuilder {
        // obligatorios
        private final String direccion;
        private final double precio;
        // opcionales con valores por defecto
        private int habitaciones = 1;
        private int banos = 1;
        private boolean tieneGarage = false;
        private boolean tienePiscina = false;
        private String descripcion = "";
        private int cuotas = 0;

        public InmuebleBuilder(String direccion, double precio) {
            this.direccion = direccion;
            this.precio = precio;
        }

        public InmuebleBuilder conHabitaciones(int habitaciones) {
            this.habitaciones = habitaciones;
            return this;
        }

        public InmuebleBuilder conBanos(int banos) {
            this.banos = banos;
            return this;
        }

        public InmuebleBuilder conGarage(boolean tieneGarage) {
            this.tieneGarage = tieneGarage;
            return this;
        }

        public InmuebleBuilder conPiscina(boolean tienePiscina) {
            this.tienePiscina = tienePiscina;
            return this;
        }

        public InmuebleBuilder conDescripcion(String descripcion) {
            this.descripcion = descripcion == null ? "" : descripcion;
            return this;
        }

        public InmuebleBuilder conCuotas(int cuotas) {
            this.cuotas = Math.max(0, cuotas);
            return this;
        }

        public Inmueble build() {
            // aquí puedes poner validaciones si quieres
            return new Inmueble(this);
        }
    }

    // Presentación multilinea (más legible)
    public void presentacion() {
        System.out.println("=== INMUEBLE GENERADO ===");
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Precio: " + this.precio);
        System.out.println("Habitaciones: " + this.habitaciones);
        System.out.println("Baños: " + this.banos);
        System.out.println("Piscina: " + (this.tienePiscina ? "Sí" : "No"));
        System.out.println("Garage: " + (this.tieneGarage ? "Sí" : "No"));
        System.out.println("Descripción: " + (this.descripcion.trim().isEmpty() ? "Sin descripción" : this.descripcion));
        if (this.cuotas > 0) {
            System.out.println("Cuotas de pago: " + this.cuotas);
        }
    }

    @Override
    public String toString() {
        // por si prefieres imprimir con println(inmueble)
        StringBuilder sb = new StringBuilder();
        sb.append("=== INMUEBLE GENERADO ===\n");
        sb.append("Dirección: ").append(this.direccion).append("\n");
        sb.append("Precio: ").append(this.precio).append("\n");
        sb.append("Habitaciones: ").append(this.habitaciones).append("\n");
        sb.append("Baños: ").append(this.banos).append("\n");
        sb.append("Piscina: ").append(this.tienePiscina ? "Sí" : "No").append("\n");
        sb.append("Garage: ").append(this.tieneGarage ? "Sí" : "No").append("\n");
        sb.append("Descripción: ").append(this.descripcion.trim().isEmpty() ? "Sin descripción" : this.descripcion).append("\n");
        if (this.cuotas > 0) {
            sb.append("Cuotas de pago: ").append(this.cuotas).append("\n");
        }
        return sb.toString();
    }
}
