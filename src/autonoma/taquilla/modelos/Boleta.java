package autonoma.taquilla.modelos;

import autonoma.taquilla.exceptions.PrecioFinalInvalidoException;

/**
 * Clase que representa una boleta de cine.
 * Contiene los atributos y métodos necesarios para gestionar la información de una boleta.
 * @author  Juan Jose Cardona Daza
 * @since 20250404
 * @version 1.0
 */
public class Boleta {

    // Atributos privados
    private Pelicula pelicula; // Pelicula seleccionada
    private Funcion funcion;   // Funcion seleccionada
    private Usuario usuario;   // Usuario que compra la boleta
    private double precioTotal; // Precio total de la boleta

    /**
     * Constructor que inicializa los atributos de la boleta.
     * @param pelicula Pelicula seleccionada.
     * @param funcion Funcion seleccionada.
     * @param usuario Usuario que compra la boleta.
     */
    public Boleta(Pelicula pelicula, Funcion funcion, Usuario usuario) {
        this.pelicula = pelicula;
        this.funcion = funcion;
        this.usuario = usuario;
        this.precioTotal = 0; // Inicializa el precio total en 0
    }

    /**
     * Calcula el precio total de la boleta aplicando descuentos según el usuario y la función.
     * @return Precio total calculado.
     * @throws PrecioFinalInvalidoException Si el precio calculado es negativo.
     */
    public double calcularPrecioTotal() throws PrecioFinalInvalidoException {
        this.precioTotal = usuario.aplicarDescuento(pelicula.getCostoBase(), funcion);
        if (precioTotal < 0) {
            throw new PrecioFinalInvalidoException("El precio final no puede ser negativo.");
        }
        return precioTotal;
    }

    // Métodos Getters y Setters

    /**
     * Obtiene la película asociada a la boleta.
     * @return Película seleccionada.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Establece una nueva película para la boleta.
     * @param pelicula Película a asociar.
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * Obtiene la función asociada a la boleta.
     * @return Función seleccionada.
     */
    public Funcion getFuncion() {
        return funcion;
    }

    /**
     * Establece una nueva función para la boleta.
     * @param funcion Función a asociar.
     */
    public void setFuncion(Funcion funcion) {
        this.funcion = funcion;
    }

    /**
     * Obtiene el usuario asociado a la boleta.
     * @return Usuario que compra la boleta.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece un nuevo usuario para la boleta.
     * @param usuario Usuario a asociar.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el precio total de la boleta.
     * @return Precio total calculado.
     */
    public double getPrecioTotal() {
        return precioTotal;
    }

    /**
     * Establece un nuevo precio total para la boleta.
     * @param precioTotal Precio total a establecer.
     */
    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }
}