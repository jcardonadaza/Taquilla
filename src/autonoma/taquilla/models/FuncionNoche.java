package autonoma.taquilla.models;
/**
 * Clase que representa una funcion de cine en horario nocturno.
 * Extiende la clase abstracta Funcion y define el calculo del descuento especifico para esta funcion.
 * Por defecto, no se aplica descuento en las funciones nocturnas.
 */
public class FuncionNoche extends Funcion {

    /**
     * @author Alejandro
     * @since 20250404
     * @version 1.0
     */
    /**
     * Constructor que inicializa los atributos de la funcion nocturna.
     * @param pelicula Pelicula asociada a la funcion nocturna.
     */
    public FuncionNoche(Pelicula pelicula) {
        super(0, pelicula, "Funcion noche");
    }

    /**
     * Calcula el precio final de la pelicula aplicando el descuento correspondiente.
     * En las funciones nocturnas, el descuento es del 0%.
     * @param costoBase Costo base de la pelicula.
     * @return Precio final despues de aplicar el descuento.
     */
    @Override
    public double calcularDescuento(double costoBase) {
        double descuento = costoBase * this.porcentajeDescuento; // Calcula el descuento (0% por defecto)
        return costoBase - descuento; // Retorna el precio final
    }
}