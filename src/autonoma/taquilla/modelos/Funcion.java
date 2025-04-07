package autonoma.taquilla.modelos;


/**
 * Clase abstracta que representa una funcion de cine.
 * Define los atributos y metodos comunes para las diferentes funciones.
 * Las subclases deben implementar el calculo del descuento especifico para cada funcion.
 */
public abstract class Funcion {

    // Atributos protegidos
    protected double porcentajeDescuento; // Porcentaje de descuento aplicado a la funcion
    protected Pelicula pelicula;          // Pelicula asociada a la funcion
    protected String nombreFuncion;       // Nombre de la funcion

    /**
     * Constructor que inicializa los atributos de la clase `Funcion`.
     * @param porcentajeDescuento Porcentaje de descuento aplicado.
     * @param pelicula Pelicula asociada a la funcion.
     * @param nombre Nombre de la funcion.
     */
    public Funcion(double porcentajeDescuento, Pelicula pelicula, String nombre) {
        this.porcentajeDescuento = porcentajeDescuento;
        this.pelicula = pelicula;
        this.nombreFuncion = nombre;
    }

    // Metodos Getters y Setters

    /**
     * Obtiene el porcentaje de descuento aplicado a la funcion.
     * @return Porcentaje de descuento.
     */
    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    /**
     * Establece un nuevo porcentaje de descuento para la funcion.
     * @param porcentajeDescuento Porcentaje de descuento a establecer.
     */
    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    /**
     * Obtiene la pelicula asociada a la funcion.
     * @return Pelicula asociada.
     */
    public Pelicula getPelicula() {
        return pelicula;
    }

    /**
     * Establece una nueva pelicula para la funcion.
     * @param pelicula Pelicula a asociar.
     */
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    /**
     * Obtiene el nombre de la funcion.
     * @return Nombre de la funcion.
     */
    public String getNombreFuncion() {
        return nombreFuncion;
    }

    /**
     * Establece un nuevo nombre para la funcion.
     * @param nombreFuncion Nombre de la funcion a establecer.
     */
    public void setNombreFuncion(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    // Metodo abstracto

    /**
     * Calcula el descuento aplicado al costo base de la pelicula.
     * Este metodo debe ser implementado por las subclases.
     * @param costoBase Costo base de la pelicula.
     * @return Descuento calculado.
     */
    public abstract double calcularDescuento(double costoBase);
}