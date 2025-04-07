package autonoma.taquilla.modelos;


/**
 * Clase que representa una funcion de cine en el horario de la primera funcion.
 * Extiende la clase abstracta Funcion y define el calculo del descuento especifico para esta funcion.
 * En la primera funcion, se aplica un descuento del 50% por defecto.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public class PrimeraFuncion extends Funcion {

    /**
     * Constructor que inicializa los atributos de la primera funcion.
     * @param pelicula Pelicula asociada a la primera funcion.
     */
    public PrimeraFuncion(Pelicula pelicula) {
        super(0.5, pelicula, "Primera funcion");
    }

    /**
     * Calcula el precio final de la pelicula aplicando el descuento correspondiente.
     * En la primera funcion, el descuento es del 50%.
     * @param costoBase Costo base de la pelicula.
     * @return Precio final despues de aplicar el descuento.
     */
    @Override
    public double calcularDescuento(double costoBase) {
        double descuento = costoBase * this.porcentajeDescuento; // Calcula el descuento
        return costoBase - descuento; // Retorna el precio final
    }
}