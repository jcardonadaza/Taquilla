package autonoma.taquilla.modelos;
/**
 * Modelo que permite representar un descuento si es un niño.
 * Extiende la clase abstracta `Usuario` y aplica un descuento especifico para usuarios niños.
 * El descuento por defecto es de 500 unidades monetarias.
 * @author juan Jose Cardona Daza
 * @since 20250402
 * @version 1.0
 */
public class UsuarioNino extends Usuario {

    /**
     * Constructor que inicializa los atributos del usuario niño.
     * @param id Identificador unico del usuario niño.
     */
    public UsuarioNino(String id) {
        super(500, "Usuario nino", id);
    }

    /**
     * Aplica el descuento correspondiente al usuario niño.
     * Calcula el precio final basado en el descuento de la funcion y el descuento del usuario.
     * @param costoBase Costo base de la pelicula.
     * @param funcion Funcion seleccionada.
     * @return Precio final despues de aplicar los descuentos.
     */
    @Override
    public double aplicarDescuento(double costoBase, Funcion funcion) {
        double precioConDescuento = funcion.calcularDescuento(costoBase); // Aplica el descuento de la funcion
        double precioFinalNino = precioConDescuento - this.valorDescuento; // Aplica el descuento del usuario niño
        return precioFinalNino;
    }
}