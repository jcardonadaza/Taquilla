package autonoma.taquilla.main;

import autonoma.taquilla.exceptions.PrecioFinalInvalidoException;
import autonoma.taquilla.modelos.Boleta;
import autonoma.taquilla.modelos.Cartelera;
import autonoma.taquilla.modelos.Cine;
import autonoma.taquilla.modelos.Factura;
import autonoma.taquilla.modelos.Funcion;
import autonoma.taquilla.modelos.FuncionNoche;
import autonoma.taquilla.modelos.FuncionTarde;
import autonoma.taquilla.modelos.Pelicula;
import autonoma.taquilla.modelos.PrimeraFuncion;
import autonoma.taquilla.modelos.Usuario;
import autonoma.taquilla.modelos.UsuarioAdulto;
import autonoma.taquilla.modelos.UsuarioMayor;
import autonoma.taquilla.modelos.UsuarioNino;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal para gestionar el sistema de taquilla de cine.
 * Permite administrar películas, usuarios, funciones y ventas de boletas.
 */
public class Taquilla {

    private static final Scanner teclado = new Scanner(System.in);
    private static final Cartelera cartelera = new Cartelera();
    private static final Cine cine = new Cine(cartelera);
    private static Usuario usuarioActual = null;

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = teclado.nextInt();
            teclado.nextLine(); // Consumir el carácter de nueva línea después de nextInt()
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
        teclado.nextLine(); // Consumir el carácter de nueva línea después de nextDouble()
        Pelicula nuevaPelicula = new Pelicula(nombre, costoBase);

        if (cine.gestionarPeliculas(nuevaPelicula)) {
            System.out.println("Película agregada con éxito.");
        } else {
            System.out.println("La película ya está en cartelera.");
        }
    }

    private static void mostrarPeliculas() {
        ArrayList<Pelicula> peliculas = cartelera.getPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles.");
        } else {
            System.out.println("Películas disponibles:");
            for (Pelicula pelicula : peliculas) {
                System.out.println("Nombre: " + pelicula.getNombre());
                System.out.println("Costo base: " + pelicula.getCostoBase());
            }
        }
    }

    private static void registrarUsuario() {
        System.out.print("Ingrese su ID: ");
        String id = teclado.nextLine();
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1) Niño  2) Adulto  3) Mayor");
        int tipoUsuario = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea después de nextInt()

        switch (tipoUsuario) {
            case 1 -> usuarioActual = new UsuarioNino(id);
            case 2 -> usuarioActual = new UsuarioAdulto(id);
            case 3 -> usuarioActual = new UsuarioMayor(id);
            default -> {
                System.out.println("Tipo de usuario inválido.");
                return;
            }
        }

        if (cine.agregarUsuario(usuarioActual)) {
            System.out.println("Usuario registrado con éxito.");
        } else {
            System.out.println("El usuario ya está registrado.");
        }
    }

    private static void mostrarUsuarios() {
        ArrayList<Usuario> usuarios = cine.getUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios registrados:");
            for (Usuario usuario : usuarios) {
                System.out.println("ID: " + usuario.getId());
                System.out.println("Tipo: " + usuario.getTipoUsuario());
                System.out.println("Descuento: " + usuario.getValorDescuento());
            }
        }
    }

    private static void venderBoleta() {
        if (cartelera.getPeliculas().isEmpty()) {
            System.out.println("No hay películas disponibles.");
            return;
        }
        if (usuarioActual == null) {
            System.out.println("Debe registrar un usuario antes de vender una boleta.");
            return;
        }

        System.out.print("Ingrese el nombre de la película: ");
        String nombrePelicula = teclado.nextLine();
        Pelicula pelicula = cartelera.obtenerPelicula(nombrePelicula);

        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }

        System.out.println("Seleccione la función:");
        System.out.println("1) Primera función  2) Función tarde  3) Función noche");
        int tipoFuncion = teclado.nextInt();
        teclado.nextLine(); // Consumir el carácter de nueva línea después de nextInt()

        Funcion funcion = switch (tipoFuncion) {
            case 1 -> new PrimeraFuncion(pelicula);
            case 2 -> new FuncionTarde(pelicula);
            case 3 -> new FuncionNoche(pelicula);
            default -> {
                System.out.println("Opción inválida.");
                yield null;
            }
        };

        if (funcion != null) {
            try {
                Boleta boleta = cine.venderBoleta(pelicula, funcion, usuarioActual);
                System.out.println("Boleta generada con éxito.");
            } catch (PrecioFinalInvalidoException e) {
                System.out.println("Error al generar la boleta: " + e.getMessage());
            }
        }
    }

    private static void generarFacturas() {
        ArrayList<Factura> facturas = cine.getFacturas();
        if (facturas.isEmpty()) {
            System.out.println("No hay facturas generadas.");
        } else {
            for (int i = 0; i < facturas.size(); i++) {
                System.out.println("Factura " + (i + 1) + ":");
                System.out.println(facturas.get(i).generarFactura());
            }
        }
    }

    private static void eliminarPelicula() {
        System.out.print("Ingrese el nombre de la película a eliminar: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el costo base de la película: ");
        double costoBase = teclado.nextDouble();
        teclado.nextLine(); // Consumir el carácter de nueva línea después de nextDouble()

        Pelicula pelicula = new Pelicula(nombre, costoBase);
        if (cine.getCartelera().eliminarPelicula(pelicula)) {
            System.out.println("Película eliminada con éxito.");
        } else {
            System.out.println("La película no se encontró en la cartelera.");
        }
    }
}