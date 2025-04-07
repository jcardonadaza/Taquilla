package autonoma.taquilla.modelos;

import java.util.ArrayList;

/**
 * Clase que representa una factura de compra en el cine.
 * Gestiona las ventas realizadas y permite generar un resumen detallado de la factura.
 * Incluye metodos para agregar, eliminar y actualizar ventas asociadas a la factura.
 */
public class Factura {

    // Atributos
    private ArrayList<Venta> ventas; // Lista de ventas asociadas a la factura

    /**
     * Constructor que inicializa la lista de ventas.
     */
    public Factura() {
        this.ventas = new ArrayList<>();
    }

    // Metodos principales

    /**
     * Agrega una venta a la lista de ventas.
     * @param venta Venta a agregar.
     * @return `true` si la venta fue agregada correctamente.
     */
    public boolean agregarVenta(Venta venta) {
        return ventas.add(venta);
    }

    /**
     * Elimina una venta de la lista de ventas basada en la boleta asociada.
     * @param boleta Boleta asociada a la venta a eliminar.
     * @return `true` si la venta fue eliminada, `false` si no se encontro.
     */
    public boolean eliminarVenta(Boleta boleta) {
        return ventas.removeIf(venta -> venta.getBoleta().equals(boleta));
    }

    /**
     * Actualiza una venta existente en la lista de ventas.
     * @param venta Venta con los datos actualizados.
     * @return `true` si la venta fue actualizada, `false` si no se encontro.
     */
    public boolean actualizarVenta(Venta venta) {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getBoleta().equals(venta.getBoleta())) {
                ventas.set(i, venta);
                return true;
            }
        }
        return false;
    }

    /**
     * Genera un resumen detallado de la factura.
     * Incluye informacion del usuario, las ventas realizadas y el total a pagar.
     * @return Cadena con el resumen de la factura.
     */
    public String generarFactura() {
        StringBuilder facturaMostrar = new StringBuilder();
        double total = 0;

        facturaMostrar.append("       FACTURA DE COMPRA         \n");

        if (ventas.isEmpty()) {
            facturaMostrar.append("Aun no hay ventas registradas.\n");
            return facturaMostrar.toString();
        }

        Boleta primeraBoleta = ventas.get(0).getBoleta();
        Usuario usuario = primeraBoleta.getUsuario();

        facturaMostrar.append("ID usuario: ").append(usuario.getId()).append("\n");
        facturaMostrar.append("Tipo de usuario: ").append(usuario.getTipoUsuario()).append("\n");
        facturaMostrar.append("Descuento segun Usuario: ").append(usuario.getValorDescuento()).append("\n");
        facturaMostrar.append("Boletas compradas:\n");

        for (Venta venta : ventas) {
            Boleta boleta = venta.getBoleta();
            Pelicula pelicula = boleta.getPelicula();
            Funcion funcion = boleta.getFuncion();

            facturaMostrar.append("   Pelicula: ").append(pelicula.getNombre()).append("\n");
            facturaMostrar.append("   Funcion: ").append(funcion.getNombreFuncion()).append("\n");
            facturaMostrar.append("   Descuento por funcion: ").append(funcion.getPorcentajeDescuento()).append("\n");
            facturaMostrar.append("   Costo base de la pelicula: ").append(pelicula.getCostoBase()).append("\n");
            facturaMostrar.append("   Precio total: ").append(boleta.getPrecioTotal()).append("\n\n");

            total += boleta.getPrecioTotal();
        }

        facturaMostrar.append("Total a pagar: ").append(total).append("\n");

        return facturaMostrar.toString();
    }

    // Metodos Getters y Setters

    /**
     * Obtiene la lista de ventas asociadas a la factura.
     * @return Lista de ventas.
     */
    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    /**
     * Establece una nueva lista de ventas.
     * @param ventas Lista de ventas a establecer.
     */
    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }
}