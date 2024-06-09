// grupoC_System.java
package grupoC;

public class grupoC_System {
    public void procesarPedido(grupoC_User usuario) {
        // Lógica para procesar un pedido
        System.out.println("Procesando pedido para: " + usuario.getNombre() + " " + usuario.getApellido());
        System.out.println("Dirección de envío: " + usuario.getDireccion());
        System.out.println("Correo electrónico: " + usuario.getCorreo());
        System.out.println("Número de teléfono: " + usuario.getTelefono());
        // Aquí puedes agregar más lógica para completar el pedido
    }
}  