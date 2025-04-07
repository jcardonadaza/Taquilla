package autonoma.taquilla.modelos;

/**
 * Modelo que representa un usuario adulto.
 * No aplica descuento adicional, pero permite calcular el precio final basado en la funcion seleccionada.
 * Extiende la clase abstracta `Usuario`.
 * @author Juan Jose Cardona Daza
 * @since 20250402
 * @version 1.0
 */
public class UsuarioAdulto extends Usuario {

    /**
     * Constructor que inicializa los atributos del usuario adulto.
     * @param id Identificador unico del usuario adulto.
     */
    public UsuarioAdulto(String id) {
        super(0, "Usuario adulto", id);
    }

    /**
     * Aplica el descuento correspondiente al usuario adulto.
     * En este caso, no se aplica descuento adicional, pero se calcula el precio final basado en la funcion.
     * @param costoBase Costo base de la pelicula.
     * @param funcion Funcion seleccionada.
     * @return Precio final despues de aplicar los descuentos.
     */
    @Override
    public double aplicarDescuento(double costoBase, Funcion funcion) {
        double precioConDescuento = funcion.calcularDescuento(costoBase); // Aplica el descuento de la funcion
        double precioFinalAdulto = precioConDescuento - this.valorDescuento; // Aplica el descuento del usuario (0 en este caso)
        return precioFinalAdulto;
    }
}