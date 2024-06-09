// grupoC_User.java
package grupoC;
import java.util.Scanner;

public class grupoC_User {
    private String nombre;
    private String apellido;
    private String direccion;
    private String correo;
    private String telefono;
 
    // Constructor
    public grupoC_User(Scanner scanner) {
        boolean datosValidos = false;
        while (!datosValidos) {
            System.out.print("Ingrese su nombre: ");
            nombre = scanner.nextLine().trim();
            // El nombre no debe estar vacío
            if (!nombre.isEmpty()) {
                System.out.print("Ingrese su apellido: ");
                apellido = scanner.nextLine().trim();
                // El apellido no debe estar vacío
                if (!apellido.isEmpty()) {
                    System.out.print("Ingrese su dirección: ");
                    direccion = scanner.nextLine().trim();
                    // La dirección no debe estar vacía
                    if (!direccion.isEmpty()) {
                        System.out.print("Ingrese su correo electrónico: ");
                        correo = scanner.nextLine().trim();
                        // El correo electrónico no debe estar vacío y debe contener los símbolos '@' y '.'
                        if (!correo.isEmpty() && correo.contains("@") && correo.contains(".")) {
                            System.out.print("Ingrese su número de teléfono: ");
                            telefono = scanner.nextLine().trim();
                            // El número de teléfono no debe estar vacío y debe contener solo dígitos numéricos
                            if (!telefono.isEmpty() && telefono.matches("\\d+")) {
                                datosValidos = true;
                            } else {
                                System.out.println("El número de teléfono es inválido. Por favor, ingréselo nuevamente.");
                            }
                        } else {
                            System.out.println("El correo electrónico es inválido. Por favor, ingréselo nuevamente.");
                        }
                    } else {
                        System.out.println("La dirección no puede estar vacía. Por favor, ingrésela nuevamente.");
                    }
                } else {
                    System.out.println("El apellido no puede estar vacío. Por favor, ingréselo nuevamente.");
                }
            } else {
                System.out.println("El nombre no puede estar vacío. Por favor, ingréselo nuevamente.");
            }
        }
    }
    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() { 
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}