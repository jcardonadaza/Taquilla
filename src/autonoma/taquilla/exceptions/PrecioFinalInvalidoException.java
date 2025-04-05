package autonoma.taquilla.exceptions;

/**
 *
 * @author Juan Jose Cardona Daza
 */
public class PrecioFinalInvalidoException extends Exception {
    public PrecioFinalInvalidoException(){
        super("El precio de la boleta debe de ser mayor o igual a 0");
    }
    
}
