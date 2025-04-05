package autonoma.taquilla.main;

import autonoma.taquillaCine.exceptions.PrecioFinalInvalidoException;
import autonoma.taquillaCine.models.Boleta;
import autonoma.taquillaCine.models.Cartelera;
import autonoma.taquillaCine.models.Cine;
import autonoma.taquillaCine.models.Factura;
import autonoma.taquillaCine.models.Funcion;
import autonoma.taquillaCine.models.FuncionNoche;
import autonoma.taquillaCine.models.FuncionTarde;
import autonoma.taquillaCine.models.Pelicula;
import autonoma.taquillaCine.models.PrimeraFuncion;
import autonoma.taquillaCine.models.Usuario;
import autonoma.taquillaCine.models.UsuarioAdulto;
import autonoma.taquillaCine.models.UsuarioMayor;
import autonoma.taquillaCine.models.UsuarioNino;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal para gestionar el sistema de taquilla de cine.
 * Permite administrar películas, usuarios, funciones y ventas de boletas.
 * @author 
 * @since 20250404
 * @version 1.1
 */
public class TaquillaCine {

    private static final Scanner teclado = new Scanner(System.in);
    private static final Cartelera cartelera = new Cartelera();
    private static final Cine cine = new Cine(cartelera);
    private static Usuario usuarioActual = null;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer
            procesarOpcion(opcion);
        } while (opcion != 8);
    }

    /**
     * Muestra el menú principal al usuario.
     */
    private static void mostrarMenu() {
        System.out.println("Bienvenido a la gestión del cine");
        System.out.println("1) Gestionar películas");
        System.out.println("2) Mostrar películas disponibles");
        System.out.println("3) Registrar usuario");
        System.out.println("4) Mostrar usuarios");
        System.out.println("5) Vender boleta");
        System.out.println("6) Generar factura");
        System.out.println("7) Eliminar película");
        System.out.println("8) Salir");
        System.out.print("Ingrese una opción: ");
    }

    /**
     * Procesa la opción seleccionada por el usuario.
     * @param opcion Opción seleccionada.
     */
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> gestionarPeliculas();
            case 2 -> mostrarPeliculas();
            case 3 -> registrarUsuario();
            case 4 -> mostrarUsuarios();
            case 5 -> venderBoleta();
            case 6 -> generarFacturas();
            case 7 -> eliminarPelicula();
            case 8 -> System.out.println("Gracias por usar el sistema. ¡Hasta pronto!");
            default -> System.out.println("Opción inválida. Intente nuevamente.");
        }
    }

    private static void gestionarPeliculas() {
        System.out.print("Ingrese el nombre de la película: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el costo base de la película: ");
        double costoBase = teclado.nextDouble();
        Pelicula nuevaPelicula = new Pelicula(nombre, costoBase);

        if (cine.gestionarPeliculas(nuevaPelicula)) {
            System.out.println("Película agregada con éxito.");
        } else {
            System.out.println("La película ya está en cartelera.");
        }
    }
}