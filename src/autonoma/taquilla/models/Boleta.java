package autonoma.taquilla.models;

import autonoma.taquillaCine.exceptions.PrecioFinalInvalidoException;

/**
 * Clase que representa una boleta de cine, asociada a una pelicula, funcion y usuario.
 * Permite calcular el precio total aplicando descuentos segun el tipo de usuario y funcion.
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
     * Calcula el precio total de la boleta aplicando descuentos segun el usuario y la funcion.
     * @return Precio total calculado.
     * @throws PrecioFinalInvalidoException Si el precio calculado es negativo.
     *
    */

    public double calcularPrecioTotal() throws PrecioFinalInvalidoException {
        this.precioTotal = usuario.aplicarDescuento(pelicula.getCostoBase(), funcion);
        if (precioTotal < 0) {
            throw new PrecioFinalInvalidoException("El precio final no puede ser negativo.");
        }
        return precioTotal;
    }

    // Metodos Getters y Setters

    /**
     * Obtiene la pelicula asociada a la boleta.
     * @return Pelicula seleccionada.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Establece una nueva pelicula para la boleta.
     * @param pelicula Pelicula a asociar.
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * Obtiene la funcion asociada a la boleta.
     * @return Funcion seleccionada.
     */
    public Funcion getFuncion() {
        return funcion;
    }

    /**
     * Establece una nueva funcion para la boleta.
     * @param funcion Funcion a asociar.
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
