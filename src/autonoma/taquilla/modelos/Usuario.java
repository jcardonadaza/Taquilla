package autonoma.taquilla.modelos;

/**
 * Modelo que permite representar un usuario.
 * Define los atributos y metodos comunes para los diferentes tipos de usuarios.
 * Las subclases deben implementar el metodo para aplicar el descuento especifico.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public abstract class Usuario {

    protected double valorDescuento; 
    protected String tipoUsuario;    
    protected String id;             

    /**
     * Constructor que inicializa los atributos de la clase Usuario.
     * @param valorDescuento Porcentaje de descuento del usuario.
     * @param tipo Tipo de usuario.
     * @param id Identificador del usuario.
     */
    public Usuario(double valorDescuento, String tipo, String id) {
        this.valorDescuento = valorDescuento;
        this.tipoUsuario = tipo;
        this.id = id;
    }

    // Metodos Getters y Setters

    /**
     * Retorna el valor de descuento del usuario.
     * @return Valor de descuento.
     */
    public double getValorDescuento() {
        return valorDescuento;
    }

    /**
     * Modifica el valor de descuento del usuario.
     * @param valorDescuento Nuevo valor de descuento.
     */
    public void setValorDescuento(double valorDescuento) {
        this.valorDescuento = valorDescuento;
    }

    /**
     * Retorna el tipo de usuario.
     * @return Tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Modifica el tipo de usuario.
     * @param tipoUsuario Nuevo tipo de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Retorna el identificador del usuario.
     * @return Identificador del usuario.
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo abstracto que modela la aplicacion del descuento.
     * Este metodo debe ser implementado por las subclases.
     * @param costoBase Costo base de la pelicula.
     * @param funcion Funcion asociada.
     * @return Costo final despues de aplicar el descuento.
     */
    public abstract double aplicarDescuento(double costoBase, Funcion funcion);
}