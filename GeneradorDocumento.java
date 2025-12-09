package Inmueble;

// Creador Abstracto (Factory Method)
public abstract class GeneradorDocumento {

    // Factory Method
    protected abstract Documento crearDocumento();

    // Método adicional para usar el documento
    public Documento generarDocumento() {
        return crearDocumento();
    }

    public void procesarYGuardar() {
        Documento doc = crearDocumento();
        doc.generarPDF();
        System.out.println("Guardando documento tipo: " + doc.getTipo());
    }
}
