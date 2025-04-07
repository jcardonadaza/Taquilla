package autonoma.taquilla.modelos;

/**
 * Modelo que permite representar un descuento si es un niño.
 * Extiende la clase abstracta Usuario y aplica un descuento especifico para usuarios niños.
 * El descuento por defecto es de 500 unidades monetarias.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public class Nino extends Usuario {

    /**
     * Constructor que inicializa los atributos del usuario niño.
     * @param id Identificador unico del usuario niño.
     */
    public Nino(String id) {
        super(500, "nino", id);
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
        double precioConDescuento = funcion.calcularDescuento(costoBase); 
        double precioFinalNino = precioConDescuento - this.valorDescuento; 
        return precioFinalNino;
    }
}