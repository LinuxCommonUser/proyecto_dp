package Inmueble;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class TestAdapter {

    @Test
    void testAdapterCreaArchivoReal() throws IOException {
        String archivoPrueba = "test_db.txt";
        
        // 1. Limpiar rastro previo
        Files.deleteIfExists(Path.of(archivoPrueba));

        // 2. Crear Inmueble y Adapter
        Inmueble local = new Inmueble.InmuebleBuilder("Local Comercial 55", 50000).build();
        Exportador adaptador = new AdaptadorArchivo(archivoPrueba);

        // 3. Ejecutar
        adaptador.guardar(local);

        // 4. Verificar
        File archivo = new File(archivoPrueba);
        assertTrue(archivo.exists(), "El archivo de base de datos debería existir");
        assertTrue(archivo.length() > 0, "El archivo no debería estar vacío");
        
        // Limpieza final
        archivo.delete();
    }
}