package autonoma.taquilla.models;

import java.util.ArrayList;

 /**
     * @author  Juan Jose Cardona Daza
     * @since 20250404
     * @version 1.0
     */
public class Cartelera {

    // Atributos
    private ArrayList<Pelicula> peliculas; // Lista de peliculas disponibles en la cartelera

    /**
     * Constructor que inicializa la lista de peliculas.
     */
    public Cartelera() {
        this.peliculas = new ArrayList<>();
    }

    /**
     * Devuelve la lista completa de peliculas en la cartelera.
     * @return Lista de peliculas.
     */
    public ArrayList<Pelicula> mostrarPeliculas() {
        return this.peliculas;
    }

    /**
     * Verifica si una pelicula existe en la cartelera.
     * @param pelicula Pelicula a buscar.
     * @return `true` si la pelicula existe, de lo contrario `false`.
     */
    public boolean buscarPelicula(Pelicula pelicula) {
        return peliculas.stream().anyMatch(p -> p.getNombre().equals(pelicula.getNombre()));
    }

    /**
     * Busca una pelicula por su nombre y la devuelve.
     * @param nombre Nombre de la pelicula a buscar.
     * @return La pelicula encontrada o `null` si no existe.
     */
    public Pelicula obtenerPelicula(String nombre) {
        return peliculas.stream()
                .filter(p -> p.getNombre().equals(nombre))
                .findFirst()
                .orElse(null);
    }

    /**
     * Agrega una nueva pelicula a la cartelera si no existe previamente.
     * @param pelicula Pelicula a agregar.
     * @return `true` si la pelicula fue agregada, `false` si ya existia.
     */
    public boolean agregarPelicula(Pelicula pelicula) {
        if (buscarPelicula(pelicula)) {
            return false;
        }
        peliculas.add(pelicula);
        return true;
    }

    /**
     * Elimina una pelicula de la cartelera si existe.
     * @param pelicula Pelicula a eliminar.
     * @return `true` si la pelicula fue eliminada, `false` si no existia.
     */
    public boolean eliminarPelicula(Pelicula pelicula) {
        return peliculas.removeIf(p -> p.getNombre().equals(pelicula.getNombre()));
    }

    /**
     * Actualiza una pelicula existente en la cartelera.
     * @param pelicula Pelicula con los datos actualizados.
     * @return `true` si la pelicula fue actualizada, `false` si no se encontro.
     */
    public boolean actualizarPelicula(Pelicula pelicula) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getNombre().equals(pelicula.getNombre())) {
                peliculas.set(i, pelicula);
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de peliculas.
     * @return Lista de peliculas.
     */
    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    /**
     * Establece una nueva lista de peliculas.
     * @param peliculas Lista de peliculas a establecer.
     */
    public void setPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
}