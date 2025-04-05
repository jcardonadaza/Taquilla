package autonoma.taquillaCine.models;

/**
 * Modelo que permite representar un descuento si es un usuario mayor.
 * Extiende la clase abstracta Usuario y aplica un descuento especifico para usuarios mayores.
 * El descuento por defecto es de 1000 unidades monetarias.
 * @author Alejandro 
 * @since 20250405
 * @version 1.0
 */
public class UsuarioMayor extends Usuario {

    /**
     * Constructor que inicializa los atributos del usuario mayor.
     * @param id Identificador unico del usuario mayor.
     */
    public UsuarioMayor(String id) {
        super(1000, "Usuario mayor", id);
    }

    /**
     * Aplica el descuento correspondiente al usuario mayor.
     * Calcula el precio final basado en el descuento de la funcion y el descuento del usuario.
     * @param costoBase Costo base de la pelicula.
     * @param funcion Funcion seleccionada.
     * @return Precio final despues de aplicar los descuentos.
     */
    @Override
    public double aplicarDescuento(double costoBase, Funcion funcion) {
        double precioConDescuento = funcion.calcularDescuento(costoBase); 
        double precioFinalMayor = precioConDescuento - this.valorDescuento; 
        return precioFinalMayor;
    }
}