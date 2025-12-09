package Inmueble;

import java.util.Scanner;

public class SistemaInmobiliarioFacade {

    // ---------------- Crear Inmueble ----------------
    public Inmueble crearInmueble(Scanner sc) {
        System.out.println("\n=== CREACIÓN DE INMUEBLE ===");

        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();

        double precio = 0;
        while (true) {
            System.out.print("Ingrese precio: ");
            try {
                precio = Double.parseDouble(sc.nextLine());
                if(precio < 0) throw new Exception();
                break;
            } catch(Exception e) {
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }

        int habitaciones = leerEntero(sc, "Número de habitaciones: ");
        int banos = leerEntero(sc, "Número de baños: ");

        System.out.print("¿Tiene piscina? (s/n): ");
        boolean piscina = sc.nextLine().equalsIgnoreCase("s");

        System.out.print("¿Tiene garaje? (s/n): ");
        boolean garage = sc.nextLine().equalsIgnoreCase("s");

        System.out.print("Descripción opcional: ");
        String descripcion = sc.nextLine();

        int cuotas = leerEntero(sc, "Número de cuotas (0 si no aplica): ");

        // 1. Crear Inmueble con Builder (Patrón Creacional)
        Inmueble inmueble = new Inmueble.InmuebleBuilder(direccion, precio)
                .conHabitaciones(habitaciones)
                .conBanos(banos)
                .conGarage(garage)
                .conPiscina(piscina)
                .conDescripcion(descripcion)
                .conCuotas(cuotas)
                .build();

        // 2. NUEVO: Persistencia usando Adapter (Patrón Estructural)
        // Esto guarda el inmueble en un archivo real "inmuebles_db.txt"
        try {
            Exportador exportador = new AdaptadorArchivo("inmuebles_db.txt");
            exportador.guardar(inmueble);
        } catch (Exception e) {
            System.out.println("Advertencia: No se pudo guardar el respaldo en disco.");
        }

        return inmueble;
    }

    // ---------------- Seleccionar Pago ----------------
    public void seleccionarPago(Inmueble inmueble, Scanner sc) {
        System.out.println("\nSeleccione forma de pago:");
        System.out.println("1. Contado");
        System.out.println("2. Cuotas");
        System.out.println("3. Descuento");
        int opcion = leerEntero(sc, "Opción: ");

        PrecioStrategy estrategia;

        switch(opcion) {
            case 1 -> estrategia = new PrecioContado();
            case 2 -> estrategia = new PrecioCuotas(0.015); // 1.5% por cuota
            case 3 -> {
                System.out.print("Ingrese porcentaje de descuento (ej. 0.1 = 10%): ");
                double descuento = 0;
                try { descuento = Double.parseDouble(sc.nextLine()); } catch(Exception e) { descuento = 0; }
                estrategia = new PrecioDescuento(descuento);
            }
            default -> {
                System.out.println("Opción inválida. Se usará pago al contado.");
                estrategia = new PrecioContado();
            }
        }

        double precioFinal = estrategia.calcularPrecioFinal(inmueble, inmueble.getCuotas());
        System.out.println("\n=== RESULTADO DEL PAGO ===");
        inmueble.presentacion(); // Asumiendo que agregaste este método en Inmueble, o usa presentacion()
        System.out.println("Forma de pago: " + estrategia.getDescripcion());
        System.out.printf("Precio final: %.2f\n", precioFinal);
    }

    // ---------------- Generar Contratos ----------------
    public void generarContratoVenta() {
        System.out.println("[Generando contrato de venta...]");
        // Aquí podrías agregar lógica real, PDF, archivo, etc.
    }

    public void generarContratoAlquiler() {
        System.out.println("[Generando contrato de alquiler...]");
        // Aquí podrías agregar lógica real, PDF, archivo, etc.
    }

    // ---------------- Método auxiliar ----------------
    private int leerEntero(Scanner sc, String mensaje) {
        int valor = -1;
        while(valor < 0) {
            System.out.print(mensaje);
            try { valor = Integer.parseInt(sc.nextLine()); }
            catch(Exception e) { System.out.println("Entrada inválida. Intente de nuevo."); }
        }
        return valor;
    }
}