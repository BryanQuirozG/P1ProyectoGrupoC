// grupoC_Products.java
package grupoC;

import java.util.ArrayList;
import java.util.List;

public class grupoC_Products {
    private List<Product> listaProductos;

    // Constructor
    public grupoC_Products() {
        listaProductos = new ArrayList<>();
        // Inicializar la lista de productos
        inicializarProductos();
    }

    // Método para inicializar la lista de productos
    private void inicializarProductos() {
        listaProductos.add(new ProductGourmet("Cacao Fino de Aroma", 15.50, 5));
        listaProductos.add(new ProductGourmet("Café de Altura", 12.00, 5));
        // Agregar más productos según sea necesario
    }

    // Método para obtener la lista de productos
    public List<Product> getListaProductos() {
        return listaProductos;
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(String nombre, double precio, int stock) {
        listaProductos.add(new ProductGourmet(nombre, precio, stock));
    }

    // Clase interna para representar un producto gourmet
    private static class ProductGourmet extends Product {
        public ProductGourmet(String nombre, double precio, int stock) {
            super(nombre, precio, stock);
        }

        @Override
        public void mostrarInformacion() {
            System.out.println("Producto: " + getNombre() + ", Precio: $" + getPrecio() + ", Stock: " + getStock());
        }
    }

    // Clase abstracta para representar un producto
    public abstract static class Product {
        private String nombre;
        private double precio;
        private int stock;

        public Product(String nombre, double precio, int stock) {
            this.nombre = nombre;
            this.precio = precio;
            this.stock = stock;
        }
  
        public String getNombre() {
            return nombre;
        }

        public double getPrecio() {
            return precio;
        }

        public int getStock() {
            return stock;
        }

        public abstract void mostrarInformacion();
    }
}