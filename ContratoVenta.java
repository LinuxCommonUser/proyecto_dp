package Inmueble;

public class ContratoVenta implements Documento {

    public void generarPDF() {
        System.out.println("PDF del Contrato de Venta generado correctamente");
    }

    public String getTipo() {
        return "CONTRATO_VENTA";
    }
}
