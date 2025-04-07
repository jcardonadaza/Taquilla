package autonoma.taquilla.modelos;

/**
 * Clase que representa una pelicula.
 * Contiene los atributos y metodos necesarios para gestionar la informacion de una pelicula.
 * @author Alejandro
 * @since 20250405
 * @version 1.0
 */
public class Pelicula {

    // Atributos privados
    private String nombre;     // Nombre de la pelicula
    private double costoBase;  // Costo base de la pelicula

    /**
     * Constructor que inicializa los atributos de la clase Pelicula.
     * @param nombre Nombre de la pelicula.
     * @param costoBase Costo base de la pelicula.
     */
    public Pelicula(String nombre, double costoBase) {
        this.nombre = nombre;
        this.costoBase = costoBase;
    }

    // Metodos Getters y Setters

    /**
     * Obtiene el nombre de la pelicula.
     * @return Nombre de la pelicula.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para la pelicula.
     * @param nombre Nombre de la pelicula a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el costo base de la pelicula.
     * @return Costo base de la pelicula.
     */
    public double getCostoBase() {
        return costoBase;
    }

    /**
     * Establece un nuevo costo base para la pelicula.
     * @param costoBase Costo base de la pelicula a establecer.
     */
    public void setCostoBase(double costoBase) {
        this.costoBase = costoBase;
    }
}