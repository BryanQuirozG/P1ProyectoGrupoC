// grupoC_Store.java
package grupoC;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class grupoC_Store {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    private grupoC_Products productos;
    private grupoC_System sistema;
    private grupoC_User usuario;
    private Scanner scanner;

    // Constructor
    public grupoC_Store() {
        scanner = new Scanner(System.in); // Inicializar scanner aquí
        productos = new grupoC_Products();
        sistema = new grupoC_System();
        usuario = new grupoC_User(scanner); // Pasar el scanner al constructor de grupoC_User
    }

    // Método estático para crear una instancia básica
    public static grupoC_Store crearInstanciaBasica() {
        System.out.println(ANSI_GREEN + "Creando instancia básica de la tienda en línea" + ANSI_RESET);
        return new grupoC_Store();
    }

    // Métodos para interactuar con la tienda
    public void mostrarMenuPrincipal() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Tienda en Línea Gourmet ---");
            System.out.println("1. Mostrar productos");
            System.out.println("2. Agregar producto");
            System.out.println("3. Realizar pedido");
            System.out.println("4. Guardar productos en CSV");
            System.out.println("5. Guardar productos en JSON");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");

            if (scanner.hasNextInt()) {
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        mostrarProductos();
                        break;
                    case 2:
                        agregarProducto();
                        break;
                    case 3:
                        realizarPedido();
                        break;
                    case 4:
                        guardarProductosEnCSV();
                        break;
                    case 5:
                        guardarProductosEnJSON();
                        break;
                    case 6:
                        salir = true;
                        System.out.println("Salida del Programa.");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } else {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.nextLine(); // Consumir la entrada inválida
            }
        }
        scanner.close(); // Cerrar el Scanner después del bucle
    }
 
    public void mostrarProductos() {
        List<grupoC_Products.Product> listaProductos = productos.getListaProductos();
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Catálogo de productos:");
            for (grupoC_Products.Product producto : listaProductos) {
                producto.mostrarInformacion();
            }
        }
    }

    public void agregarProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        productos.agregarProducto(nombre, precio, stock);
        System.out.println(ANSI_GREEN + "Producto agregado exitosamente." + ANSI_RESET);
    }

    public void realizarPedido() {
        // Lógica para realizar un pedido
        sistema.procesarPedido(usuario);
    }

    public void guardarProductosEnCSV() {
        System.out.print("Ingrese el nombre del archivo CSV: ");
        String nombreArchivo = scanner.nextLine();
        guardarProductosEnCSV(nombreArchivo);
    }

    public void guardarProductosEnJSON() {
        System.out.print("Ingrese el nombre del archivo JSON: ");
        String nombreArchivo = scanner.nextLine();
        guardarProductosEnJSON(nombreArchivo);
    }

    // Método para guardar los productos en un archivo CSV
    public void guardarProductosEnCSV(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Nombre,Precio,Stock\n");
            for (grupoC_Products.Product producto : productos.getListaProductos()) {
                sb.append(producto.getNombre()).append(",")
                        .append(producto.getPrecio()).append(",")
                        .append(producto.getStock()).append("\n");
            }
            writer.write(sb.toString());
            System.out.println(ANSI_GREEN + "Productos guardados en el archivo CSV: " + nombreArchivo + ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error al guardar el archivo CSV: " + e.getMessage() + ANSI_RESET);
            e.printStackTrace(); // Imprimir el seguimiento de la pila de la excepción
        }
    }

    // Método para guardar los productos en un archivo JSON
    public void guardarProductosEnJSON(String nombreArchivo) {
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            List<grupoC_Products.Product> listaProductos = productos.getListaProductos();
            for (int i = 0; i < listaProductos.size(); i++) {
                grupoC_Products.Product producto = listaProductos.get(i);
                sb.append("{");
                sb.append("\"nombre\":\"").append(producto.getNombre()).append("\",");
                sb.append("\"precio\":").append(producto.getPrecio()).append(",");
                sb.append("\"stock\":").append(producto.getStock());
                sb.append("}");

                if (i < listaProductos.size() - 1) {
                    sb.append(",");
                }
            }

            sb.append("]");
            writer.write(sb.toString());
            System.out.println(ANSI_GREEN + "Productos guardados en el archivo JSON: " + nombreArchivo + ANSI_RESET);
        } catch (IOException e) {
            System.out.println(ANSI_RED + "Error al guardar el archivo JSON: " + e.getMessage() + ANSI_RESET);
            e.printStackTrace(); // Imprimir el seguimiento de la pila de la excepción
        }
    }

    // Nuevo método getScanner()
    public Scanner getScanner() {
        return scanner;
    }
}