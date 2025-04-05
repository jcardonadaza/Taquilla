package autonoma.taquilla.models;


import autonoma.taquilla.exceptions.PrecioFinalInvalidoException;
import java.util.ArrayList;

/**
 * Clase que representa un cine.
 * Gestiona la cartelera, los usuarios, las facturas y las ventas de boletas.
 * Proporciona metodos para administrar peliculas, usuarios y generar facturas.
 */
public class Cine {

    // Atributos
    private Cartelera cartelera; // Instancia de la cartelera del cine
    private ArrayList<Factura> facturas; // Lista de facturas generadas
    private ArrayList<Usuario> usuarios; // Lista de usuarios registrados

    /**
     * Constructor que inicializa los atributos del cine.
     * @param cartelera Instancia de la cartelera asociada al cine.
     */
    public Cine(Cartelera cartelera) {
        this.cartelera = cartelera;
        this.facturas = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    // Metodos principales

    /**
     * Vende una boleta para una pelicula y funcion especifica.
     * Genera una factura asociada a la venta.
     * @param pelicula Pelicula seleccionada.
     * @param funcion Funcion seleccionada.
     * @param usuario Usuario que compra la boleta.
     * @return Boleta generada o `null` si la pelicula no esta en la cartelera.
     * @throws PrecioFinalInvalidoException Si el precio calculado es invalido.
     */
    public Boleta venderBoleta(Pelicula pelicula, Funcion funcion, Usuario usuario) throws PrecioFinalInvalidoException {
        if (cartelera.buscarPelicula(pelicula)) {
            Boleta boletaNueva = new Boleta(pelicula, funcion, usuario);
            boletaNueva.calcularPrecioTotal();

            Venta ventaNueva = new Venta(boletaNueva);
            Factura facturaNueva = new Factura();
            facturaNueva.agregarVenta(ventaNueva);

            this.facturas.add(facturaNueva);
            return boletaNueva;
        }
        return null;
    }

    /**
     * Gestiona la adicion de una pelicula a la cartelera.
     * @param pelicula Pelicula a agregar.
     * @return `true` si la pelicula fue agregada, `false` si ya existia.
     */
    public boolean gestionarPeliculas(Pelicula pelicula) {
        return this.cartelera.agregarPelicula(pelicula);
    }

    /**
     * Genera una factura para un usuario especifico basado en su ID.
     * @param id ID del usuario.
     * @return Factura generada como cadena o `null` si no se encuentra.
     */
    public String generarFactura(String id) {
        for (Factura factura : this.facturas) {
            for (Venta venta : factura.getVentas()) {
                if (venta.getBoleta().getUsuario().getId().equals(id)) {
                    return factura.generarFactura();
                }
            }
        }
        return null;
    }

    // Metodos relacionados con usuarios

    /**
     * Busca si un usuario existe en la lista de usuarios por su ID.
     * @param id ID del usuario a buscar.
     * @return `true` si el usuario existe, `false` de lo contrario.
     */
    public boolean buscarUsuario(String id) {
        return usuarios.stream().anyMatch(usuario -> usuario.getId().equals(id));
    }

    /**
     * Agrega un nuevo usuario al sistema si no existe previamente.
     * @param usuario Usuario a agregar.
     * @return `true` si el usuario fue agregado, `false` si ya existia.
     */
    public boolean agregarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getId())) {
            return false;
        }
        this.usuarios.add(usuario);
        return true;
    }

    /**
     * Obtiene un usuario por su ID.
     * @param id ID del usuario a buscar.
     * @return Usuario encontrado o `null` si no existe.
     */
    public Usuario obtenerUsuarioPorId(String id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Getters y Setters

    /**
     * Obtiene la lista de facturas generadas.
     * @return Lista de facturas.
     */
    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    /**
     * Establece una nueva lista de facturas.
     * @param facturas Lista de facturas a establecer.
     */
    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }

    /**
     * Obtiene la lista de usuarios registrados.
     * @return Lista de usuarios.
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Obtiene la instancia de la cartelera asociada al cine.
     * @return Instancia de la cartelera.
     */
    public Cartelera getCartelera() {
        return cartelera;
    }

    /**
     * Establece una nueva instancia de cartelera.
     * @param cartelera Instancia de cartelera a establecer.
     */
    public void setCartelera(Cartelera cartelera) {
        this.cartelera = cartelera;
    }
}