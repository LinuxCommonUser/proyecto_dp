package Inmueble;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n=== SISTEMA DE DOCUMENTOS INMOBILIARIOS ===");
            System.out.println("1. Generar Contrato de Venta");
            System.out.println("2. Generar Contrato de Alquiler");
            System.out.println("3. Generar Inmueble (Builder)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {

                case 1: {
                    System.out.println(">> Generando Contrato de Venta...");
                    GeneradorDocumento genVenta = FabricaGenerador.crear("VENTA");
                    Documento docVenta = genVenta.generarDocumento();
                    System.out.println("Tipo de documento generado: " + docVenta.getTipo());
                    docVenta.generarPDF();
                    break;
                }

                case 2: {
                    System.out.println(">> Generando Contrato de Alquiler...");
                    GeneradorDocumento genAlq = FabricaGenerador.crear("ALQUILER");
                    Documento docAlq = genAlq.generarDocumento();
                    System.out.println("Tipo de documento generado: " + docAlq.getTipo());
                    docAlq.generarPDF();
                    break;
                }

                case 3:
                    System.out.println("\n>> Opción seleccionada: Crear Inmueble (Builder)");
                    generarInmueble(scanner);
                    break;

                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    // ============================
    // MÉTODO INTEGRADO PARA BUILDER
    // ============================
    private static void generarInmueble(Scanner scanner) {

        System.out.println("\n=== CREACIÓN DE INMUEBLE ===");

        System.out.print("Ingrese dirección: ");
        String direccion = scanner.nextLine();

        System.out.print("Ingrese precio: ");
        double precio = Double.parseDouble(scanner.nextLine());

        System.out.print("Número de habitaciones: ");
        int habitaciones = Integer.parseInt(scanner.nextLine());

        System.out.print("Número de baños: ");
        int banos = Integer.parseInt(scanner.nextLine());

        System.out.print("¿Tiene piscina? (s/n): ");
        boolean piscina = scanner.nextLine().equalsIgnoreCase("s");

        System.out.print("¿Tiene garaje? (s/n): ");
        boolean garage = scanner.nextLine().equalsIgnoreCase("s");

        System.out.print("Descripción opcional (Enter para omitir): ");
        String descripcion = scanner.nextLine();

        System.out.print("Número de cuotas de pago (0 si no aplica): ");
        int cuotas = Integer.parseInt(scanner.nextLine());

        // --- Construimos el Inmueble con el Builder ---
        Inmueble inmueble = new Inmueble.InmuebleBuilder(direccion, precio)
                .conHabitaciones(habitaciones)
                .conBanos(banos)
                .conPiscina(piscina)
                .conGarage(garage)
                .conDescripcion(descripcion)
                .build();

        System.out.println("\n=== INMUEBLE GENERADO ===");
        inmueble.presentacion();
        System.out.println("Cuotas de pago: " + (cuotas > 0 ? cuotas : "No aplica"));
    }
}
