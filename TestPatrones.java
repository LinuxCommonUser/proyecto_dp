package Inmueble;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestPatrones {

    // 1. TEST PATRÓN BUILDER
    @Test
    void testBuilderCreaObjetoCorrectamente() {
        Inmueble casa = new Inmueble.InmuebleBuilder("Av. Siempre Viva 123", 100000)
                .conHabitaciones(3)
                .conPiscina(true)
                .build();

        assertEquals("Av. Siempre Viva 123", casa.getDireccion());
        assertEquals(100000, casa.getPrecio());
        assertEquals(3, casa.getHabitaciones());
        assertTrue(casa.getTienePiscina());
        assertFalse(casa.getTieneGarage()); // Por defecto debe ser false
    }

    // 2. TEST PATRÓN STRATEGY
    @Test
    void testEstrategiaDescuento() {
        Inmueble depto = new Inmueble.InmuebleBuilder("Centro", 200000).build();
        
        // Descuento del 10%
        PrecioStrategy estrategia = new PrecioDescuento(0.10);
        double precioFinal = estrategia.calcularPrecioFinal(depto, 0);

        assertEquals(180000, precioFinal, 0.01);
    }

    @Test
    void testEstrategiaCuotas() {
        Inmueble depto = new Inmueble.InmuebleBuilder("Centro", 1000).build();
        
        // 10 cuotas con 1.5% de interés simple CADA UNA
        // Interés total = 10 * 1.5% = 15%. Precio = 1000 + 150 = 1150
        PrecioStrategy estrategia = new PrecioCuotas(0.015);
        double precioFinal = estrategia.calcularPrecioFinal(depto, 10);

        assertEquals(1150, precioFinal, 0.01);
    }

    // 3. TEST PATRÓN FACTORY METHOD (Creacional)
    @Test
    void testFactoryCreaDocumentoCorrecto() {
        GeneradorDocumento gen = FabricaGenerador.crear("VENTA");
        Documento doc = gen.generarDocumento();

        assertTrue(doc instanceof ContratoVenta);
        assertEquals("CONTRATO_VENTA", doc.getTipo());
    }
    
    // 4. TEST PATRÓN OBSERVER (Comportamiento)
    @Test
    void testObserverNotificacion() {
        // Como ObservadorConsola imprime en pantalla, aquí probamos que no lance errores
        // En un entorno real usaríamos Mocks, pero esto valida la integración básica
        Notificador notificador = new Notificador("Agente 1");
        Inmueble casa = new Inmueble.InmuebleBuilder("Test", 100).build();
        
        assertDoesNotThrow(() -> notificador.actualizar(casa, "Precio bajó"));
    }
}