package Inmueble;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class AdaptadorArchivo implements Exportador {

    private final String nombreArchivo;

    public AdaptadorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public void guardar(Inmueble inmueble) {
        // Lógica real de persistencia (Append mode = true)
        try (FileWriter fw = new FileWriter(nombreArchivo, true);
             PrintWriter pw = new PrintWriter(fw)) {
            
            pw.println(inmueble.toString());
            pw.println("--------------------------------------------------");
            System.out.println(">> [SISTEMA] Inmueble guardado correctamente en: " + nombreArchivo);
            
        } catch (IOException e) {
            System.err.println(">> [ERROR] No se pudo guardar el archivo: " + e.getMessage());
        }
    }
}