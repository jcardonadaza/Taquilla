package autonoma.taquilla.exceptions;

/**
 * Excepción personalizada para manejar errores relacionados con precios inválidos.
 */
public class PrecioFinalInvalidoException extends Exception {

    /**
     * Constructor sin parámetros.
     */
    public PrecioFinalInvalidoException() {
        super("El precio de la boleta debe de ser mayor o igual a 0");
    }

    /**
     * Constructor que acepta un mensaje personalizado.
     * @param message Mensaje de error.
     */
    public PrecioFinalInvalidoException(String message) {
        super(message);
    }
}