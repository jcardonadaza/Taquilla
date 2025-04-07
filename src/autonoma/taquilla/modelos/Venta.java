package autonoma.taquilla.modelos;

/**
 * Modelo que permite representar una venta.
 * Contiene una instancia de boleta asociada a la venta y permite gestionarla.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public class Venta {

    // Atributos
    private Boleta boleta; // Instancia de boleta asociada a la venta

    /**
     * Constructor que inicializa los atributos de la clase Venta.
     * @param boleta Boleta asociada a la venta.
     */
    public Venta(Boleta boleta) {
        this.boleta = boleta;
    }

    // Metodos Getters y Setters

    /**
     * Retorna la boleta asociada a la venta.
     * @return Boleta asociada.
     */
    public Boleta getBoleta() {
        return boleta;
    }

    /**
     * Modifica la boleta asociada a la venta.
     * @param boleta Nueva boleta a asociar.
     */
    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }
}