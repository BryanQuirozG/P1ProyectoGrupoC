package grupoC;

public class grupoC_Main {
    public static void main(String[] args) {
        grupoC_Store tienda = grupoC_Store.crearInstanciaBasica();
        tienda.mostrarMenuPrincipal();
        tienda.getScanner().close(); // Cerrar el Scanner después de utilizar la tienda
    }
} 