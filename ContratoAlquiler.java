package Inmueble;

public class ContratoAlquiler implements Documento {

    public void generarPDF() {
        System.out.println("PDF del Contrato de Alquiler generado correctamente");
    }

    public String getTipo() {
        return "CONTRATO_ALQUILER";
    }
}
