package autonoma.taquilla.modelos;

/**
 * Clase que representa una funcion de cine en horario de la tarde.
 * Extiende la clase abstracta Funcion y define el calculo del descuento especifico para esta funcion.
 * En las funciones de la tarde, se aplica un descuento del 10% por defecto.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public class FuncionTarde extends Funcion {

    /**
     * Constructor que inicializa los atributos de la funcion tarde.
     * @param pelicula Pelicula asociada a la funcion tarde.
     */
    public FuncionTarde(Pelicula pelicula) {
        super(0.1, pelicula, "Funcion tarde");
    }

    /**
     * Calcula el precio final de la pelicula aplicando el descuento correspondiente.
     * En las funciones de la tarde, el descuento es del 10%.
     * @param costoBase Costo base de la pelicula.
     * @return Precio final despues de aplicar el descuento.
     */
    @Override
    public double calcularDescuento(double costoBase) {
        double descuento = costoBase * this.porcentajeDescuento;
        return costoBase - descuento; 
    }
}
