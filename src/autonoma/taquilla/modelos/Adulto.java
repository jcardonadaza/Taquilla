package autonoma.taquilla.modelos;

/**
 * Modelo que representa un usuario adulto.
 * No aplica descuento adicional, pero permite calcular el precio final basado en la funcion seleccionada.
 * Extiende la clase abstracta Usuario.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public class Adulto extends Usuario {

    /**
     * Constructor que inicializa los atributos del usuario adulto.
     * @param id Identificador unico del usuario adulto.
     */
    public Adulto(String id) {
        super(0, " adulto", id);
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
        double precioConDescuento = funcion.calcularDescuento(costoBase); 
        double precioFinalAdulto = precioConDescuento - this.valorDescuento; 
        return precioFinalAdulto;
    }
}